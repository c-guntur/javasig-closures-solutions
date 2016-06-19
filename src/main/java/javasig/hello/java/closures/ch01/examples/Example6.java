package javasig.hello.java.closures.ch01.examples;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Partial application:
 *      convert a multi-argument function into one that accepts fewer arguments,
 *      with values for the elided arguments supplied in advance.
 *
 * Currying:
 *      convert a multi-argument function into a chain of single-argument functions.
 */

public class Example6 {
    static interface TriFunction<A, B, C, D> {
        D apply(A a, B b, C c);
    }


    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println(add.apply(1, 6));

        //Partial application
        Function<Integer, Integer> addOne = c -> add.apply(1, c);
        System.out.println(addOne.apply(6));


        //Normal
        TriFunction<Integer, Integer, String, String> concatThree =
                (a, b, c) -> String.valueOf(a) + " " + String.valueOf(b) + " :: " + c;
        System.out.println(concatThree.apply(1, 2, "hello"));


        //Currying
        Function<Integer, Function<Integer, Function<String, String>>> concatThreeAgain =
                (a) -> (b) -> (c) -> String.valueOf(a) + " " + String.valueOf(b) + " :: " + c;
        System.out.println(concatThreeAgain.apply(3).apply(4).apply("world"));
    }

}