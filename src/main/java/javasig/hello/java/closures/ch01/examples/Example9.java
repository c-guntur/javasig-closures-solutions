package javasig.hello.java.closures.ch01.examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Custom Suppliers, Consumers, Functions and Predicates
 */
public class Example9 {
    public static void main(String[] args) {
        //------------------------------------
        // Suppliers and Consumers

        // As a lambda:
        Supplier<Integer> lengthGetter = () -> "The length of this string should be 38".length();
        // As a method reference:
        //Supplier<Integer> lengthGetter = "The length of this string should be 38"::length;

        // As a method reference
        Consumer<Integer> outputEmitter = System.out::println;

        outputEmitter.accept(lengthGetter.get());

        //====================================
        Integer[] numbers = {1,2,3,4,5,6,7,8,9,10};
        List<Integer> numbersList = Arrays.asList(numbers);

        //------------------------------------
        // Custom Function
        Function<Integer, Integer> squareFunction = x -> x * x;
        for (Integer number : numbersList) {
            Integer numberSquared = squareFunction.apply(number);
            System.out.println("The square of " + number + " is : " + numberSquared);
        }

        //------------------------------------
        // Custom Predicate
        Predicate<Integer> isEven = x -> x %2 == 0;
        Predicate<Integer> greaterThanEight = x -> x > 8;
        for(Integer number : numbersList) {
            System.out.println("Is " + number + " even? : "+ isEven.test(number));
            System.out.println("Is " + number + " greater than eight? "+ greaterThanEight.test(number));
        }

    }
}