package javasig.hello.java.closures.ch01.examples;

/**
 * Custom functional interfaces - Single Abstract Method (SAM) type - multiple uses.
 */
public class Example8 {

    private static interface Calculator {
        public int calculate(int x, int y);
    }

    public static void main(String[] args) {
        Example8 demo = new Example8();
        demo.classicStyle();
        demo.java8Style();
    }

    public void classicStyle() {
        Calculator addition = new Calculator() {
            @Override
            public int calculate(int x, int y) {
                return x + y;
            }
        };

        Calculator subtraction = new Calculator() {
            @Override
            public int calculate(int x, int y) {
                return x - y;
            }
        };

        Calculator multiplication = new Calculator() {
            @Override
            public int calculate(int x, int y) {
                return x * y;
            }
        };

        System.out.println("2 + 3 = " + addition.calculate(2,3));
        System.out.println("5 - 2 = " + subtraction.calculate(5,2));
        System.out.println("2 * 5 = " + multiplication.calculate(2,5));
    }

    public void java8Style() {
        Calculator addition = (int x, int y) -> x + y;
        Calculator subtraction = (int x, int y) -> x - y;
        Calculator multiplication = (int x, int y) -> x * y;

        System.out.println("2 + 3 = " + addition.calculate(2,3));
        System.out.println("5 - 2 = " + subtraction.calculate(5,2));
        System.out.println("2 * 5 = " + multiplication.calculate(2,5));
    }
}