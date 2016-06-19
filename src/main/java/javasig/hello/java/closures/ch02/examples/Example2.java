package javasig.hello.java.closures.ch02.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a list of strings, sort a copy in an ascending order. Print the list in a separate call.
 */
public class Example2 {

    // Create a list of randomly ordered Strings.
    List<String> codeslist = Arrays.asList("a1", "c8", "a2", "b4", "c7", "a3", "b5", "c9", "c6");

    public static void main(String[] args) {
        Example2 demo = new Example2();
        demo.classicStyle();
        System.out.println();
        demo.java8Style();

    }

    public void classicStyle() {
        System.out.println("Classic Style: ");
        System.out.println("===============");
        List<String> myList = new ArrayList<>(codeslist);
        // Sort
        Collections.sort(myList);

        // Print
        for (String eachString : myList) {
            System.out.print(eachString + " ");
        }
    }

    public void java8Style() {
        System.out.println("\nJava 8 Style: ");
        System.out.println("==============");
        List<String> myList = null; // Fix this null

        //DONE: Implement the logic to sort codesList into myList.
/*********************************************************************************/
        // Sort
        // Note that we first uppercase and then sort, which makes more sense.
        myList = codeslist.stream()
                // Sort
                .sorted()
                // Terminate !!! Use the Collectors utility.
                .collect(Collectors.toList());
/*********************************************************************************/

        // Print
        // DONE: Uncomment 2 line below
        myList.stream()
                .forEach(s -> System.out.print(s + " "));
    }
}