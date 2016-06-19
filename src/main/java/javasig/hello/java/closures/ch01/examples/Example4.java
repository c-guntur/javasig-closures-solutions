package javasig.hello.java.closures.ch01.examples;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Supplier;

/**
 * Method references
 */
public class Example4 {
    public static void main(String[] args) {

        // Function uses a lambda expression
        Function<Integer, String> func1 = x -> Integer.toBinaryString(x);
        System.out.println("Integer.toBinaryString lambda call: " + func1.apply(10));

        // Function uses method reference
        Function<Integer, String> func2 = Integer::toBinaryString;
        System.out.println("Integer.toBinaryString method references call: " + func2.apply(10));

        //-----------------------------------------------------

        // BiFunction uses a lambda expression
        BiFunction<Integer, Integer, Integer> func3 = (x, y) -> Integer.sum(x, y);
        System.out.println("BiFunction lambda sum call: " + func3.apply(2, 3));

        // BiFunction uses a method reference
        BiFunction<Integer, Integer, Integer> func4 = Integer::sum;
        System.out.println("BiFunction method reference sum call: " + func4.apply(2, 3));


        //-------------------------------Overloading
        // Uses  Integer.valueOf(int)
        Function<Integer, Integer> func5 = Integer::valueOf;
        System.out.println("Integer.valueOf(int) method reference call: " + func5.apply(7));

        // Uses  Integer.valueOf(String)
        Function<String, Integer> func6 = Integer::valueOf;
        System.out.println("Integer.valueOf(String) method reference call: " + func6.apply("7"));

        // Uses  Integer.valueOf(String, int)
        BiFunction<String, Integer, Integer> func7 = Integer::valueOf;
        System.out.println("Integer.valueOf(String, int) method reference call: " + func7.apply("101010101010", 2));


        // --------------------------------Suppliers
        // @See java.util.function.Supplier  & java.util.function.Consumer.
        Supplier<String> stringSupplier = () -> "Hello NYJavaSIG";
        System.out.println(stringSupplier.get());

        // Supplier uses a lambda expression
        Supplier<String> func8 = () -> new String();
        System.out.println("Empty String:" + func8.get());

        // Supplier uses  a  method  reference
        Supplier<String> func9 = String::new;
        System.out.println("Empty String:" + func9.get());

        // Introducing IntFunction (Java 8 provides IntFunction, LongFunction and DoubleFunction.
        IntFunction<int[]> intArrayMaker = int[]::new;
        int[] tenInts = intArrayMaker.apply(10);
        for (int x = 0; x < tenInts.length; x++) {
            tenInts[x] = x;
        }
    }
}
