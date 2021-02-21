package babycino;

import java.io.PrintWriter;
import java.util.List;

// Generate C code from Three Address Code.
// This might not truly be "machine" code, but the C code is pretty close.
public class CGenerator implements MachineGenerator {
    public CGenerator() {
    }

    // Generate C code corresponding to "code" and write it to "w".
    public void generate(PrintWriter w, List<TACBlock> code) {
        // Find safe bounds for number of parameters/global registers to define.
        int maxParam = maxParams(code);
        int maxVG = maxVGs(code);

        // Include standard C headers.
        w.println("#include <stdio.h>");
        w.println("#include <stdlib.h>");
        w.println();

        // Define "word" type for all values.
        w.println("union ilword {");
        w.println("    int n;");
        w.println("    union ilword* ptr;");
        w.println("    void(*f)();");
        w.println("};");
        w.println("typedef union ilword word;");
        w.println();

        // Define global array and counter for parameters.
        w.println("word param[" + maxParam + "];");
        w.println("int next_param = 0;");
        w.println();

        // Define global for r0.
        w.println("word r0 = {0};");
        w.println();

        // Define globals for vgs.
        for (int n = 0; n <= maxVG; n++) {
            w.println("word vg" + n + " = {0};");
        }

        // Declare prototype function for each block.
        for (TACBlock block : code) {
            if (block.size() == 0 || block.get(0).getLabel() == null) {
                continue;
            }
            String name = block.get(0).getLabel();
            w.println("void " + mangle(name) + "();");
        }

        // Dump code for main() that calls first block.
        w.println("int main() {");
        w.println("    INIT();");
        w.println("    MAIN();");
        w.println("    return 0;");
        w.println("}");
        w.println();
        
        // Dump code for each block.
        for (TACBlock block : code) {
            if (block.size() == 0 || block.get(0).getLabel() == null) {
                continue;
            }
            String name = block.get(0).getLabel();
            w.println("void " + mangle(name) + "() {");

            // Declare locals for "registers", except r0.
            if (block.getMaxVL() < 0) {
                w.println("    word vl[0];");
            }
            else {
                w.print("    word vl[" + (block.getMaxVL()+1) + "] = {0");
                for (int n = 0; n < block.getMaxVL(); n++) {
                    w.print(",0");
                }
                w.println("};");
            }
            for (int n = block.getMaxR(); n >= 1; n--) {
                w.println("    word r" + n + " = {0};");
            }
            w.println("    int p;");
            // Copy passed parameters.
            w.println("    for(p = 0; p <= " + block.getMaxVL() + " && p < " + maxParam + "; p++) {");
            w.println("        vl[p] = param[p];");
            w.println("    }");
            w.println("    next_param = 0;");

            // Produce a line/block of C for each intermediate code operation.
            for (TACOp op : block) {
                w.println(opToC(op));
            }
            w.println("}");
            w.println();
            
        }
        
        
    }

    // Make sure a name is a valid C identifier by "mangling" it.
    private static String mangle(String id) {
        if (id == null) {
            return null;
        }

        return id.replace("_", "__").
            replace(".","_").
            replace("@","_");
    }

    // Find the maximum number of times "param" is used in any code block.
    private static int maxParams(List<TACBlock> code) {
        int params = 1;
        for (TACBlock block : code) {
            params = Math.max(params, block.countParam());
        }
        return params;
    }

    // Find the maximum vg used in any code block.
    private static int maxVGs(List<TACBlock> code) {
        int vgs = -1;
        for (TACBlock block : code) {
            vgs = Math.max(vgs, block.getMaxVG());
        }
        return vgs;
    }

    // Turn a register name into a corresponding C variable name.
    private static String regToVar(String r) {
        if (r == null) {
            return null;
        }
        if (r.startsWith("r") || r.startsWith("vg")) {
            return r;
        }
        if (!r.startsWith("vl")) {
            throw new IllegalArgumentException();
        }
        return "vl[" + r.substring(2) + "]";
    }

    // Translate a Three Address Code operation into a single C statement.
    private static String opToC(TACOp op) {
        String r1 = regToVar(op.getR1());
        String r2 = regToVar(op.getR2());
        String r3 = regToVar(op.getR3());
        int n = op.getN();
        String label = mangle(op.getLabel());

        // The main difficulty is ensuring the correct usage of different fields
        // in the word union (n, ptr and f) to get the desired behaviour.
        switch (op.getType()) {
            case MOV:
                return "    " + r1 + " = " + r2 + ";";
            case IMMED:
                return "    " + r1 + ".n = " + n + ";";
            case LOAD:
                return "    " + r1 + " = *(" + r2 + ".ptr);";
            case STORE:
                return "    " + "*(" + r1 + ".ptr) = " + r2 + ";";
            case BINOP:
                if (n == TACOp.binopToCode("offset")) {
                    return "    " + r1 + ".ptr = " + r2 + ".ptr + " + r3 + ".n;";
                }
                return "    " + r1 + ".n = " + r2 + ".n " + TACOp.codeToBinop(n) + " " + r3 + ".n;";
            case PARAM:
                return "    " + "param[next_param++] = " + r1 + ";";
            case CALL:
                return "    " + "(*(" + r1 + ".f))();";
            case RET:
                return "    " + "return;";
            case LABEL:
                return "" + label + ":";
            case JMP:
                return "    " + "goto " + label + ";";
            case JZ:
                return "    " + "if (" + r1 + ".n == 0) goto " + label + ";";
            case MALLOC:
                // Use of calloc() is important, as it zeros the memory, which
                // conveniently allocates the correct default values for all
                // Java types.
                return "    " + r1 + ".ptr = calloc(" + r2 + ".n, sizeof(word));";
            case READ:
                // Not used, as we never generate it for MiniJava programs.
                return "    " + r1 + ".n = -1; scanf(\"%d\", &" + r1 + ".n);";
            case WRITE:
                return "    " + "printf(\"%d\\n\", " + r1 + ");";
            case ADDROF:
                // Address-of (&) in C works for functions, but not goto labels.
                // This only works because the TAC we generate only takes the
                // addresses of methods, for which we generate a C function.
                return "    " + r1 + ".f = &" + label + ";";
            case NOP:
                return "    ";
            default:
                throw new IllegalArgumentException();
        }
    }

}

