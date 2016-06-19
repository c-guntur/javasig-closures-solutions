package javasig.hello.java.closures.ch02.examples;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a list of strings, print out each element, in an ascending order, with uppercase.
 */
public class Example1 {

    // Create an array of randomly ordered Strings.
    private final String[] codes = {"a1", "c8", "a2", "b4", "c7", "a3", "b5", "c9", "c6"};
    // Make  alist out of those elements
    List<String> codeslist = Arrays.asList(codes);

    // FYI: This can also be written as:
    //List<String> codeslist = Arrays.asList("a1", "c8", "a2", "b4", "c7", "a3", "b5", "c9", "c6");

    public static void main(String[] args) {
        Example1 demo = new Example1();
        demo.classicStyle();
        System.out.println();
        demo.java8Style();
    }

    public void classicStyle() {
        System.out.println("Classic Style: ");
        System.out.println("===============");
        // Sort
        Collections.sort(codeslist);

        String eachString;
        for(String each: codeslist) {
            // Uppercase
            eachString = each.toUpperCase();
            // Print
            System.out.print(eachString + " ");
        }
    }

    public void java8Style() {
        System.out.println("\nJava 8 Style: ");
        System.out.println("==============");
/*********************************************************************************/
        //Note that we first uppercase and then sort, which makes more sense.
        codeslist.stream()
                // Uppercase
                .map(s -> s.toUpperCase())
                // Sort
                .sorted()
                // Print
                .forEach(eachString -> System.out.print(eachString + " "));
/*********************************************************************************/
    }
}