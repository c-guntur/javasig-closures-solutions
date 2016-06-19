package javasig.hello.java.closures.ch01.examples;

/**
 * Runnable - lambda
 */
public class Example3 {
    public static void main(String[] args) {
        Example3 demo = new Example3();
        demo.classicStyle().run();
        demo.java8Style().run();
    }

    public Runnable classicStyle() {
        // Create an inner class of Runnable and implement the run() method.
        return () -> {
            System.out.println("This is old school with an inner class");
        };
    }

    public Runnable java8Style() {
        // Since Runnable is a SAM, use a lambda to invoke its run() method.
        return () -> System.out.println("This is new school with a lambda");
    }
}