package practice.lesson3;

import java.util.Arrays;

/**
 * Напишите обобщенный метод compareArrays(), который принимает два массива и возвращает true, если они одинаковые,
 * и false в противном случае. Массивы могут быть любого типа данных, но должны иметь одинаковую длину и содержать элементы одного типа.
 */
public class ArrayComparator {
    public static <T> boolean compare(T[] a, T[] b) {
        return Arrays.equals(a, b);
    }

    public static <T> void compareNPrint(T[] a, T[] b) {
        System.out.println(print(a, b) + " -> " + compare2(a, b));
    }

    public static <T> boolean compare2(T[] a, T[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++)
            if (!a[i].equals(b[i])) return false;
        return true;
    }

    public static <T> String print(T[] a, T[] b) {
        StringBuilder sb = new StringBuilder();
        for (T t : a) sb.append(t).append(", ");
        sb.append(" compareTo ");
        for (T t : b) sb.append(t).append(", ");
        return sb.toString();
    }
}
