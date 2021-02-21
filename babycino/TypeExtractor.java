package babycino;

// A Visitor to determine the MiniJava Type of a parse subtree.
public class TypeExtractor extends MiniJavaBaseVisitor<Type> {

    private SymbolTable sym;
    
    public TypeExtractor(SymbolTable sym) {
        this.sym = sym;
    }

    @Override
    public Type visitTypeIntArray(MiniJavaParser.TypeIntArrayContext ctx) {
        return new Type(Kind.INTARRAY);
    }

    @Override
    public Type visitTypeBoolean(MiniJavaParser.TypeBooleanContext ctx) {
        return new Type(Kind.BOOLEAN);
    }

    @Override
    public Type visitTypeInt(MiniJavaParser.TypeIntContext ctx) {
        return new Type(Kind.INT);
    }

    @Override
    public Type visitTypeObject(MiniJavaParser.TypeObjectContext ctx) {
        Class c = sym.get(ctx.getText());
        if (c == null) {
            return null;
        }
        else {
            return new Type(c);
        }
    }

}

