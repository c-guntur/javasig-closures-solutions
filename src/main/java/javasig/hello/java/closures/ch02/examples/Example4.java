package javasig.hello.java.closures.ch02.examples;

import javasig.hello.java.closures.ch02.domain.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Given a list of customers, print out the names of customers who live in NYC.
 */
public class Example4 {
    public static void main(String[] args) {
        Example4 demo = new Example4();
        List<Customer> customers = Customer.seedCustomers();
        demo.classicStyle(customers);
        System.out.println();
        demo.java8Style(customers);
    }

    public void classicStyle(List<Customer> customers) {
        System.out.println("Classic Style: ");
        System.out.println("===============");
        List<Customer> nycCustomers = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.livesIn("New York")) {
                nycCustomers.add(customer);
            }
        }
        for (Customer nycCustomer : nycCustomers) {
            System.out.print(nycCustomer.getGivenName() + " ");
        }
    }

    public void java8Style(List<Customer> customers) {
        System.out.println("\nJava 8 Style: ");
        System.out.println("==============");

/*********************************************************************************/
        //DONE: 1. Collect the customers who live in NYC
        List<Customer> nycCustomers;
        nycCustomers = customers.stream()
                .filter(c -> c.livesIn("New York"))
                .collect(Collectors.toList());
        //DONE: 2. Using nycCustomers.forEach(...) print the names of the customers.
        nycCustomers.forEach(c -> System.out.print(c.getGivenName() + " "));
/*********************************************************************************/

/*********************************************************************************/
// OR SOLUTION 2
/*********************************************************************************/
        System.out.print("\n    SOLUTION 2: ");
        Predicate<Customer> isNycCustomer = c -> c.livesIn("New York");
        nycCustomers = customers.stream()
                .filter(isNycCustomer)
                .collect(Collectors.toList());

        nycCustomers.forEach(c -> System.out.print(c.getGivenName() + " "));
/*********************************************************************************/
/*********************************************************************************/



/*********************************************************************************/
// OR SOLUTION 3: COVERED AFTER BiPredicate covered in Example 5.
/*********************************************************************************/
        System.out.print("\n    SOLUTION 3: ");
        BiPredicate<Customer, String> customersInNyc = (customer, city) -> customer.getCity().equals(city);
        List<Customer> nycCustomers1;
        nycCustomers1 = customers.stream()
                .filter(c -> customersInNyc.test(c, "New York"))
                .collect(Collectors.toList());
        nycCustomers1.forEach(c -> System.out.print(c.getGivenName() + " "));
/*********************************************************************************/
/*********************************************************************************/
    }
}
