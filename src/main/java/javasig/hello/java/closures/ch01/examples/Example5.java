package javasig.hello.java.closures.ch01.examples;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Comparators - lambdas
 */
public class Example5 {
    public static void main(String[] args) {
        //-------------------------------Passing in a reference as a variable.
        Integer[] ints = {2, 1, 3, 5, 4};
        System.out.println("--------------------------------");
        System.out.print("Sorting an unsorted array of numbers: [");
        Arrays.sort(ints, Integer::compareTo);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(" "+ints[i]);
        }
        System.out.println(" ]");
        System.out.println("--------------------------------");


        //--------------------------------Old v Java 8 style
        //    Classic Style
        List<String> names = Arrays.asList("Alice", "Emily", "Cathy", "David", "Bob");
        Comparator nameSorter = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };
        //           Futility of the utility.
        Collections.sort(names, nameSorter);
        for (String name : names) {
            System.out.println(name);
        }

        //    Java 8 Style
        names = Arrays.asList("Alice", "Emily", "Cathy", "David", "Bob");
        //          Notice that we don't use the Collections utility
        names.sort((o1, o2) -> o1.compareTo(o2));
        names.forEach(System.out::println);

        //Mix and match Java 8 with classic iterations.
        String[] countries = {"France", "Czech Republic", "Poland", "Hungary", "Germany"};
        Arrays.sort(countries, (String s1, String s2) -> s1.compareTo(s2));
        prettyPrint("Countries sorted:", countries);
    }

    private static void prettyPrint(String message, String[] stringArray) {
        prettyPrint(message, Arrays.asList(stringArray));
    }

    private static void prettyPrint(String message, List<String> stringList) {
        System.out.println(message);
        for (int i = 0; i < message.length(); i++) {
            System.out.print("-");
        }
        boolean somethingPrinted = false;
        System.out.print("\n [");
        for (String aString : stringList) {
            if (somethingPrinted) {
                System.out.print(", ");
            }
            somethingPrinted = true;
            System.out.print(aString);
        }
    }
}