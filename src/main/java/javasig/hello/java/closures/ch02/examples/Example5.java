package javasig.hello.java.closures.ch02.examples;

import javasig.hello.java.closures.ch02.domain.Customer;
import javasig.hello.java.closures.ch02.domain.DiscountCustomer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Map features
 */
public class Example5 {
    public static void main(String[] args) {
        Example5 demo = new Example5();
        List<Customer> customers = Customer.seedCustomers();
        demo.classicStyle(customers);
        System.out.println();
        demo.java8Style(customers);
    }

    public void classicStyle(List<Customer> customers) {
        System.out.println("Classic Style: ");
        System.out.println("===============");
        List<DiscountCustomer> discountCustomers = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getLoyalty() > 1) {
                discountCustomers.add(customer.createDiscountCustomer());
            }
        }
        for (DiscountCustomer discountCustomer : discountCustomers) {
            System.out.print(discountCustomer.getGivenName() + " ");
        }
    }

    public void java8Style(List<Customer> customers) {
        System.out.println("\nJava 8 Style: ");
        System.out.println("==============");
        List<DiscountCustomer> discountCustomers = null;

        //DONE: 1. Try using a Predicate to extract the loyalty check.
        Predicate<Customer> isLoyal = customer -> customer.getLoyalty() > 1;

        //DONE: 2. Use the isLoyal Predicate to filter and then create discount customers
        // ... Add code below
        discountCustomers = customers.stream()
                .filter(isLoyal)
                .map(Customer::createDiscountCustomer)
                .collect(Collectors.toList());

        // DONE: Uncomment line below
        discountCustomers.forEach(dc -> System.out.print(dc.getGivenName() + " "));

        // Now lets revisit the Example 4.

    }
}