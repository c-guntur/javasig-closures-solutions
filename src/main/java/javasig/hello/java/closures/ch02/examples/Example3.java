package javasig.hello.java.closures.ch02.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Fluency via streams
 *
 * For each item price calculate the tax, print the (price+tax) list and ina separate call print the total.
 */
public class Example3 {
    List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
    private final double TAX = .12d;

    public static void main(String[] args) {
        Example3 demo = new Example3();
        demo.classicStyle();
        System.out.println();
        demo.java8Style();
    }

    public void classicStyle() {
        System.out.println("Classic Style: ");
        System.out.println("===============");

        List<Double> cost = new ArrayList<>();
        Double total = 0.0d;
        for (Integer eachPrice : costBeforeTax) {
            double price = eachPrice + eachPrice * TAX;
            cost.add(price);
            total += price;
            System.out.print(price + " ");
        }
        System.out.println("=> Price in classic style: " + total);

    }

    public void java8Style() {
        System.out.println("\nJava 8 Style: ");
        System.out.println("==============");

        List<Double> cost = new ArrayList<>();
        //DONE: 1. Implement logic to calculate costAfterTax into the cost list per item.
/*********************************************************************************/
        costBeforeTax.stream()
                .mapToDouble((eachPrice) -> eachPrice + eachPrice * TAX)
                .forEach(price -> {
                    cost.add(price);
                    System.out.print(price + " ");
                });

        //DONE: 2. Create a Double total to sum up all costs.
        // Create a Double total to sum up all costs.
        Double total = cost.stream().reduce(0.0d, Double::sum);
        System.out.println("=> Price in java8 style: " + total);
/*********************************************************************************/


/*********************************************************************************/
        // Alternate way to first collect and later print
/*********************************************************************************/
        System.out.println();
        List<Double> costAfterTax1 =
                costBeforeTax.stream()
                        .map((eachPrice) -> (eachPrice + eachPrice * TAX))
                        .collect(Collectors.toList());
        costAfterTax1.stream()
                .forEach((x) -> System.out.print(x + " "));
        System.out.println("=> Price in java8 style: " + costAfterTax1.stream().reduce(0.0d, Double::sum));
/*********************************************************************************/
/*********************************************************************************/

    }

}
