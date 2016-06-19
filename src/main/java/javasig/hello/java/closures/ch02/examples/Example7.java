package javasig.hello.java.closures.ch02.examples;

import javasig.hello.java.closures.ch02.domain.Customer;
import javasig.hello.java.closures.ch02.domain.Gender;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * General API features
 * Uncomment the TODO
 * and fix the statement to achieve the desired outcome.
 */
public class Example7 {
    public static void main(String[] args) {
        List<Customer> customers = Customer.seedCustomers();

        //---------------------------------------------------------------------
        // Map customers by Gender (
        Map<Gender, List<Customer>> customersByGenderMap = null; // Fix this null
/*********************************************************************************/
        customersByGenderMap = customers.stream().collect(Collectors.groupingBy(Customer::getGender));
        // DONE: Uncomment line below.
        customersByGenderMap.get(Gender.MALE).forEach(c -> System.out.println(c.toString()));
/*********************************************************************************/
        System.out.println();


        //---------------------------------------------------------------------
        // Map customer "names" by Gender
        Map<Gender, List<String>> customerNamesByGenderMap = null; // Fix this null
/*********************************************************************************/
        customerNamesByGenderMap = customers.stream()
                .collect(Collectors.groupingBy(Customer::getGender,
                        Collectors.mapping(c -> (c.getGivenName() + " " + c.getSurName()),
                                Collectors.toList())));
        // DONE: Uncomment line below.
        customerNamesByGenderMap.get(Gender.FEMALE).forEach(c -> System.out.println(c));
/*********************************************************************************/

        //---------------------------------------------------------------------
        //Average age of all NYC Customers
/*********************************************************************************/
        System.out.println("Average age of NYC Customers: " +
                customers.stream()
                        .filter(c -> c.livesIn("New York"))
                        .collect(Collectors.averagingDouble(c -> c.getAge())));
/*********************************************************************************/

        //---------------------------------------------------------------------
        // Average customer age by Gender
        Map<Gender, Double> customerAvgAgeByGenderMap = null; // Fix this null
/*********************************************************************************/
        customerAvgAgeByGenderMap = customers.stream()
                .collect(Collectors.groupingBy(Customer::getGender, Collectors.averagingInt(Customer::getAge)));
        // DONE: Uncomment 2 lines below.
        System.out.println("Average female customer age: "+ customerAvgAgeByGenderMap.get(Gender.FEMALE).doubleValue());
        System.out.println("Average male customer age: "+ customerAvgAgeByGenderMap.get(Gender.MALE).doubleValue());
/*********************************************************************************/

    }
}
