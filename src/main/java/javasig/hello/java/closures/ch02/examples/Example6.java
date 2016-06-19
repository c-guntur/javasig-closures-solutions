package javasig.hello.java.closures.ch02.examples;

import javasig.hello.java.closures.ch02.domain.Customer;
import javasig.hello.java.closures.ch02.domain.Gender;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * General API features
 * Uncomment the TODO
 * and fix the statement to achieve the desired outcome.
 */
public class Example6 {
    public static void main(String[] args) {
        // Run a for loop to print the first 10 numbers
        // Classic: for(int i = 0; i < 10; i++) System.out.println(i);
        System.out.println();
/*********************************************************************************/
        // DONE: Solve using a Java 8 Stream equivalent
        IntStream.range(0, 10).forEach(System.out::println);
// ----------------------- OR ----------------------------------
        IntStream.iterate(0, i -> i + 1)
                .limit(10)
                .forEach(System.out::println);
/*********************************************************************************/

        List<Customer> customers = Customer.seedCustomers();

        //---------------------------------------------------------------------
        // Find if any customer is from Chicago using a Predicate
        // Do this with both sequential and parallel streams
        Predicate<Customer> chicagoCustomers = c -> c.livesIn("Chicago");
/*********************************************************************************/
        // DONE: Solve using a stream and parallelStream usage
        System.out.println("Any Chicago customers : " + customers.stream().anyMatch(chicagoCustomers));
        System.out.println("Any Chicago customers (with parallel) : " + customers.parallelStream().anyMatch(chicagoCustomers));
/*********************************************************************************/

        System.out.println();


        //---------------------------------------------------------------------
        // Check if all customers are male using a Predicate
        // Do this with both sequential and parallel streams
/*********************************************************************************/
        // DONE: Solve using a stream and parallelStream usage
        Predicate<Customer> allMaleCustomers = c -> c.getGender() == Gender.MALE;
        System.out.println("Are all customers male? : " + customers.stream().allMatch(allMaleCustomers));
        System.out.println("Are all customers male? (with parallel) : " + customers.parallelStream().allMatch(allMaleCustomers));
/*********************************************************************************/

        System.out.println();


        //---------------------------------------------------------------------
        // Find all the cities customers are from using a Function
        Function<Customer, String> customerCities = c -> c.getCity();
        System.out.println("All distinct cities : ");
/*********************************************************************************/
        // DONE: Solve using a stream using the above function
        List<String> distinctCities = customers.stream().map(customerCities).distinct().collect(Collectors.toList());
        // DONE: Uncomment line below.
        distinctCities.forEach(System.out::println);
/*********************************************************************************/

        System.out.println();


        //---------------------------------------------------------------------
        // Find count of customers from NYC
/*********************************************************************************/
        // DONE: Solve using a stream and parallelStream usage with a Predicate
        Predicate<Customer> nycCustomers = c -> c.livesIn("New York");
        System.out.println("Count of NYC Customers : " + customers.stream().filter(nycCustomers).count());
        System.out.println("Count of NYC Customers (with parallel) : " + customers.parallelStream().filter(nycCustomers).count());
/*********************************************************************************/

        System.out.println();


        //---------------------------------------------------------------------
        // Find any customer from NYC - note we use an Optional here.
        // Do this with both sequential as well as parallel streams.
        Optional<Customer> customer;
        Predicate<Customer> nycCustomer = c -> c.livesIn("New York");
/*********************************************************************************/
        // DONE: Solve using a stream and parallelStream usage
        customer = customers.stream().filter(nycCustomers).findAny();
        System.out.println("Any NYC Customer : " + ((Customer) customer.get()).toString());
        customer = customers.parallelStream().filter(nycCustomers).findAny();
        System.out.println("Any NYC Customer (with parallel) : " + ((Customer) customer.get()).toString());
/*********************************************************************************/

        System.out.println();


        //---------------------------------------------------------------------
        // Find any customer from NYC - return the first one found.
/*********************************************************************************/
        // DONE: Solve using a stream and parallelStream usage
        customer = customers.stream().filter(nycCustomers).findFirst();
        System.out.println("First NYC Customer : " + ((Customer) customer.get()).toString());
        customer = customers.parallelStream().filter(nycCustomers).findFirst();
        System.out.println("First NYC Customer (with parallel) : " + ((Customer) customer.get()).toString());
/*********************************************************************************/

        System.out.println();


        //---------------------------------------------------------------------
        // Find total loyalty for customers from NYC
        // ***************
        // Java classic style provided as an example.
        // ***************
        int totalNYLoyalty = 0;
        for(Customer c : customers) {
            if("New York".equals(c.getCity())) {
                totalNYLoyalty += c.getLoyalty();
            }
        }
        System.out.println("Total NY Loyalty (classic): " + totalNYLoyalty);
        // ***************
        // Java 8
        // ***************
        totalNYLoyalty = 0;
/*********************************************************************************/
        // DONE: Solve using a Java8 equivalent of the above.
        totalNYLoyalty = customers.stream().filter(c -> c.livesIn("New York")).mapToInt(c -> c.getLoyalty()).sum();
        System.out.println("Total NY Loyalty (java8): " + totalNYLoyalty);
/*********************************************************************************/

        System.out.println();


        //---------------------------------------------------------------------
        // Find the sum of ages of all NYC Customers
        // bonus points for multiple solutions.

        // Bonus points for each one-liner response.
/*********************************************************************************/
        // DONE: Fix the supplier below.
        Supplier<Stream<Customer>> customerStreamSupplier = () -> customers.stream();
        // DONE: Print the sum of ages of all NYC Customers
        System.out.println("Sum of ages of NYC Customers (method 1): " +
                customerStreamSupplier.get().filter(nycCustomers).mapToInt(Customer::getAge).sum());
// ----------------------- OR ----------------------------------
        System.out.println("Sum of ages of NYC Customers (method 2): " +
                customerStreamSupplier.get().filter(nycCustomers).map(Customer::getAge).reduce(0, Integer::sum));
// ----------------------- OR ----------------------------------
        System.out.println("Sum of ages of NYC Customers (method 3): " +
                customerStreamSupplier.get().filter(nycCustomers).map(Customer::getAge).reduce(0, (a,b) -> a+b));
/*********************************************************************************/

        System.out.println();


    }
}
