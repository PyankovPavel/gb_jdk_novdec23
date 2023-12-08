package practice.lesson3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
/**
 * 1. Внедрить итератор из задания 2 в коллекцию, написанную в задании 3 таким образом,
 чтобы итератор был внутренним классом и, соответственно, объектом в коллекции.
 */
        GenCollection<Integer> collection2 = new GenCollection<>(Arrays.asList(10, 12, 13, 65));
        collection2.forEachPrint();
        System.out.println();
/**
 * 2. Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы: sum(), multiply(),
 * divide(), subtract(). Параметры этих методов – два числа разного типа, над которыми должна быть произведена операция.
 */
        System.out.println();
        System.out.println(Calc.sum(11, 22f));
        System.out.println(Calc.multiply(11.0, 22));
        System.out.println(Calc.divide(11.0, 22.0));
        System.out.println(Calc.subtract(11, 22));
        System.out.println();

/**
 *3. Напишите обобщенный метод compareArrays(), который принимает два массива и возвращает true, если они одинаковые,
 * и false в противном случае. Массивы могут быть любого типа данных, но должны иметь одинаковую длину и содержать элементы одного типа.
 */
        String[] str1 = new String[]{"test", "test123", "abc"};
        String[] str2 = new String[]{"qq", "55555", "abc"};
        String[] str3 = new String[]{"test", "test123", "abc"};
        Integer[] ints1 = new Integer[]{33, 44, 55, 66};
        Integer[] ints2 = new Integer[]{33, 44, 55, 66};
        Integer[] ints3 = new Integer[]{12, 65, 998, 78};
        ArrayComparator.compareNPrint(str1, str2);
        ArrayComparator.compareNPrint(str1, str3);
        ArrayComparator.compareNPrint(ints1, ints2);
        ArrayComparator.compareNPrint(ints3, ints1);
        System.out.println();

/**
 *4. Напишите обобщенный класс Pair, который представляет собой пару значений разного типа.
 * Класс должен иметь методы getFirst(), getSecond() для получения значений пары, а также переопределение
 * метода toString(), возвращающее строковое представление пары*/
        System.out.println();
        Pairs<String, Integer> pair1 = new Pairs<>("Test", 7777);
        Pairs<Float, Boolean> pair2 = new Pairs<>(11f, true);

        System.out.println("First: " + pair1.getFirst());
        System.out.println("Second: " + pair1.getSecond());
        System.out.println(pair1);

        System.out.println("First: " + pair2.getFirst());
        System.out.println("Second: " + pair2.getSecond());
        System.out.println(pair2);
    }
}
