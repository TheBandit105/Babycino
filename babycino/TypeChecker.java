package babycino;

import org.antlr.v4.runtime.ParserRuleContext;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Set;
import java.util.Map;

// Check the types of all expressions in the parse tree.
// Also, record the static types of the receivers of method calls for later.
public class TypeChecker extends MiniJavaBaseListener {

    // Symbol Table for the program being type-checked.
    private SymbolTable sym;
    // Class currently being type-checked.
    private Class current;
    // Method currently being type-checked.
    private Method method;
    // Flag: Have any errors occurred so far?
    private boolean errors;

    // Stack of unprocessed types, corresponding to checked subexpressions.
    private Stack<Type> types;

    public TypeChecker(SymbolTable sym) {
        this.sym = sym;
        this.method = null;
        this.errors = false;
        this.types = new Stack<Type>();
    }

    // ------------------------------------------------------------------------
    // Track what the current class/method is.

    @Override
    public void enterMainClass(MiniJavaParser.MainClassContext ctx) {
        this.current = sym.get(ctx.identifier(0).getText());
        // Set a dummy method with no variables to avoid null-pointer errors later.
        this.method = new Method("main", null, this.current, null);
    }

    @Override
    public void exitMainClass(MiniJavaParser.MainClassContext ctx) {
        this.current = null;

        // It is a fatal error if somehow not all types on the stack are used.
        if (!this.types.isEmpty()) {
            System.err.println("Internal error: not all types consumed during type-checking.");
            System.exit(1);
        }
    }

    @Override
    public void enterClassDeclaration(MiniJavaParser.ClassDeclarationContext ctx) {
        this.current = this.sym.get(ctx.identifier(0).getText());
    }

    @Override
    public void exitClassDeclaration(MiniJavaParser.ClassDeclarationContext ctx) {
        this.current = null;
    }

    @Override
    public void enterMethodDeclaration(MiniJavaParser.MethodDeclarationContext ctx) {
        this.method = this.current.getOwnMethod(ctx.identifier(0).getText());
    }

    @Override
    public void exitMethodDeclaration(MiniJavaParser.MethodDeclarationContext ctx) {
        Type t = this.types.pop();
        Type ret = this.method.getReturnType();
        this.check(ret.compatibleWith(t), ctx, "Return type of " + this.method.getQualifiedName() +
            " expected to be compatible with " + ret + "; actual type: " + t);
        this.method = null;

        // It is a fatal error if somehow not all types on the stack are used.
        if (!this.types.isEmpty()) {
            System.err.println("Internal error: not all types consumed during type-checking.");
            System.exit(1);
        }
    }

    // ------------------------------------------------------------------------
    // When leaving an expression or statement:
    // firstly, pop the types of any subexpressions off the stack and check them;
    // secondly, for expressions, push the type of the expression onto the stack.

    // Statements:

    @Override
    public void exitStmtIf(MiniJavaParser.StmtIfContext ctx) {
        Type t = this.types.pop();
        this.check(t.isBoolean(), ctx, "Expected condition of if statement to be boolean; actual type: " + t);
    }

    @Override
    public void exitStmtWhile(MiniJavaParser.StmtWhileContext ctx) {
        Type t = this.types.pop();
        this.check(t.isBoolean(), ctx, "Expected condition of while statement to be boolean; actual type: " + t);
    }

    @Override
    public void exitStmtPrint(MiniJavaParser.StmtPrintContext ctx) {
        Type t = this.types.pop();
        this.check(t.isInt(), ctx, "Expected argument of println to be int; actual type: " + t);
    }

    @Override
    public void exitStmtAssign(MiniJavaParser.StmtAssignContext ctx) {
        Type lhs = this.identifierType(ctx.identifier());
        Type rhs = this.types.pop();
        this.check(lhs.compatibleWith(rhs), ctx, "Assignment of value of type "
            + rhs + " to variable of incompatible type " + lhs);
    }

    @Override
    public void exitStmtArrayAssign(MiniJavaParser.StmtArrayAssignContext ctx) {
        Type lhs = this.identifierType(ctx.identifier());
        Type rhs = this.types.pop();
        Type index = this.types.pop();
        this.check(lhs.isIntArray(), ctx, "Expected target of array index to be int[]; actual type: " + lhs);
        this.check(index.isInt(), ctx, "Expected array index to be int; actual type: " + index);
        this.check(rhs.isInt(), ctx, "Expected int to be assigned to int array element; actual type: " + rhs);
    }

    @Override
    public void exitStmtIncrement(MiniJavaParser.StmtIncrementContext ctx) {
        Type t = this.identifierType(ctx.identifier());
        this.check(t.isInt(), ctx, "Expected argument of println to be int; actual type: " + t);
    }

//this.check(lhs.compatibleWith(rhs)
    // Expressions:

    @Override
    public void exitExpConstTrue(MiniJavaParser.ExpConstTrueContext ctx) {
        this.types.push(new Type(Kind.BOOLEAN));
    }

    @Override
    public void exitExpArrayLength(MiniJavaParser.ExpArrayLengthContext ctx) {
        Type t = this.types.pop();
        this.check(t.isIntArray(), ctx, "Expected length to be applied to expression of type int[]; actual type: " + t);
        this.types.push(new Type(Kind.INT));
    }

    @Override
    public void exitExpBinOp(MiniJavaParser.ExpBinOpContext ctx) {
        Type rhs = this.types.pop();
        Type lhs = this.types.pop();
        String op = ctx.getChild(1).getText();

        switch (op) {
            // AND is the only operator that takes booleans, not ints.
            case "&&":
                this.check(lhs.isBoolean(), ctx, "Expected boolean as 1st argument to &&; actual type: " + lhs);
                this.check(rhs.isBoolean(), ctx, "Expected boolean as 2nd argument to &&; actual type: " + rhs);
                break;
            case ">=":
                this.check(lhs.isInt(), ctx, "Expected int as 1st argument to " + op + "; actual type: " + lhs);
                this.check(rhs.isInt(), ctx, "Expected int as 2nd argument to " + op + "; actual type: " + rhs);
                break;
            default:
                this.check(lhs.isInt(), ctx, "Expected int as 1st argument to " + op + "; actual type: " + lhs);
                this.check(rhs.isInt(), ctx, "Expected int as 2nd argument to " + op + "; actual type: " + rhs);
                break;
        }

        switch (op) {
            // Only AND and less-than return booleans;
            // all other operations return ints.
            case "&&":
            case "<":
            case ">=":
                this.types.push(new Type(Kind.BOOLEAN));
                break;
            default:
                this.types.push(new Type(Kind.INT));
                break;
        }
    }

    @Override
    public void exitExpConstInt(MiniJavaParser.ExpConstIntContext ctx) {
        this.types.push(new Type(Kind.INT));
    }

    @Override
    public void enterExpMethodCall(MiniJavaParser.ExpMethodCallContext ctx) {
        // Use null to mark the start/end of argument types on the stack.
        // This is a bit off a hack.
        // Using a stack of stacks of types would avoid this.
        this.types.push(null);
    }

    @Override
    public void exitExpMethodCall(MiniJavaParser.ExpMethodCallContext ctx) {
        // Extract all the relevant types from the stack.
        Stack<Type> args = new Stack<Type>();
        while (this.types.peek() != null) {
            args.push(this.types.pop());
        }

        // Discard the null marker.
        this.types.pop();

        // Find out what the signature of the method is.
        Type lhs = args.pop();
        if (!lhs.isObject()) {
            this.error(ctx, "Expected object type for method call; actual type: " + lhs);
            this.types.push(new Type(this.sym.get("Object")));
            return;
        }
        String targetName = ctx.identifier().getText();
        Method target = lhs.getObject().getAnyMethod(targetName);
        if (target == null) {
            this.error(ctx, "Class has no matching method: " + targetName);
            this.types.push(new Type(this.sym.get("Object")));
            return;
        }

        // Store the static type of the object for code generation.
        this.sym.setStaticType(ctx, lhs);

        // Iterate through args and method's params. Check length matches. Check types compatible.
        Set<Map.Entry<String, Type>> params = target.getParams();
        if (!(params.size() == args.size())) {
            this.error(ctx, "Method " + target.getQualifiedName() + " has " +
                params.size() + " parameter(s); " + "method call has " +
                args.size() + " parameter(s).");
            this.types.push(new Type(this.sym.get("Object")));
            return;
        }

        for (Map.Entry<String, Type> param : params) {
            Type argType = args.pop();
            this.check(param.getValue().compatibleWith(argType), ctx,
                "Argument of type " + argType + " incompatible with parameter "
                + param.getKey() + " of type " + param.getValue() + ".");
        }

        // The type of the whole expression comes from the method's return type.
        this.types.push(target.getReturnType());
    }

    @Override
    public void exitExpConstFalse(MiniJavaParser.ExpConstFalseContext ctx) {
        this.types.push(new Type(Kind.BOOLEAN));
    }

    @Override
    public void exitExpArrayIndex(MiniJavaParser.ExpArrayIndexContext ctx) {
        Type index = this.types.pop();
        Type arr = this.types.pop();

        this.check(arr.isIntArray(), ctx, "Expected int[] for target of array lookup; actual type: " + arr);
        this.check(index.isInt(), ctx, "Expected int for index in array lookup; actual type: " + index);

        this.types.push(new Type(Kind.INT));
    }

    @Override
    public void exitExpNewObject(MiniJavaParser.ExpNewObjectContext ctx) {
        String id = ctx.identifier().getText();
        Class obj = this.sym.get(id);
        if (obj == null) {
            obj = this.sym.get("Object");
            this.error(ctx, "Unrecognised Class name for new object: " + id);
        }
        this.types.push(new Type(obj));
    }

    @Override
    public void exitExpNewArray(MiniJavaParser.ExpNewArrayContext ctx) {
        Type t = this.types.pop();
        this.check(t.isInt(), ctx, "Expected int for new array size; actual type: " + t);
        this.types.push(new Type(Kind.INTARRAY));
    }

    @Override
    public void exitExpNot(MiniJavaParser.ExpNotContext ctx) {
        Type t = this.types.pop();
        this.check(t.isBoolean(), ctx, "Expected boolean for argument to not; actual type: " + t);
        this.types.push(new Type(Kind.BOOLEAN));
    }

    @Override
    public void exitExpGroup(MiniJavaParser.ExpGroupContext ctx) {
        // Do nothing, as type entering/leaving group is the same.
    }

    @Override
    public void exitExpLocalVar(MiniJavaParser.ExpLocalVarContext ctx) {
        this.types.push(this.identifierType(ctx.identifier()));
    }

    @Override
    public void exitExpThis(MiniJavaParser.ExpThisContext ctx) {
        this.types.push(new Type(this.current));
    }

    // ------------------------------------------------------------------------

    // Helper method to get type of variable.
    private Type identifierType(MiniJavaParser.IdentifierContext ctx) {
        String id = ctx.getText();
        if (this.method.hasVar(id)) {
            // The variable is a method local.
            return this.method.getVarType(id);
        }
        if (this.current.hasAnyVar(id)) {
            // The variable is a class property (this.id).
            return this.current.getVarType(id);
        }
        this.error(ctx, "Undeclared variable: " + id);
        return new Type(sym.get("Object"));
    }

    // Error logging and recording:

    // Assert condition. Print error if false. Record occurrence of error.
    private void check(boolean condition, ParserRuleContext ctx, String error) {
        if (!condition) {
            System.err.println(error);
            System.err.println("Context: " + ctx.getText());
            this.errors = true;
        }
    }

    // Assert false. Print error. Record occurrence of error.
    private void error(ParserRuleContext ctx, String error) {
        System.err.println(error);
        System.err.println("Context: " + ctx.getText());
        this.errors = true;
    }

    // Throw an exception if an error previously occurred.
    public void die() throws CompilerException {
        if (this.errors) {
            throw new CompilerException();
        }
    }

}
