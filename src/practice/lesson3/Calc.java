package practice.lesson3;

public class Calc {

    public static <N extends Number> Number sum(N a, N b) {
        System.out.println((a.getClass().getName() + "|" + b.getClass().getName()).replace("java.lang.", ""));
        if (a instanceof Double || b instanceof Double) return a.doubleValue() + b.doubleValue();
        if (a instanceof Float || b instanceof Float) return a.floatValue() + b.floatValue();
        return a.intValue() + b.intValue();
    }

    public static <N extends Number> Number subtract(N a, N b) {
        System.out.println((a.getClass().getName() + "|" + b.getClass().getName()).replace("java.lang.", ""));
        if (a instanceof Double || b instanceof Double) return a.doubleValue() - b.doubleValue();
        if (a instanceof Float || b instanceof Float) return a.floatValue() - b.floatValue();
        return a.intValue() - b.intValue();
    }

    public static <N extends Number> Number multiply(N a, N b) {
        System.out.println((a.getClass().getName() + "|" + b.getClass().getName()).replace("java.lang.", ""));
        if (a instanceof Double || b instanceof Double) return a.doubleValue() * b.doubleValue();
        if (a instanceof Float || b instanceof Float) return a.floatValue() * b.floatValue();
        return a.intValue() * b.intValue();
    }

    public static <N extends Number> Number divide(N a, N b) {
        System.out.println((a.getClass().getName() + "|" + b.getClass().getName()).replace("java.lang.", ""));
        if (a instanceof Double || b instanceof Double) return a.doubleValue() / b.doubleValue();
        if (a instanceof Float || b instanceof Float) return a.floatValue() / b.floatValue();
        return a.intValue() / b.intValue();
    }

}
