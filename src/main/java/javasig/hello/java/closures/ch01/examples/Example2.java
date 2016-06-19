package javasig.hello.java.closures.ch01.examples;

/**
 * How the diamond problem is avoided
 */
public class Example2 {
    interface A {
        default void m() {
            System.out.println("m() from A");
        }
    }

    static interface B extends A {
        default void m() {
            System.out.println("m() from B");
        }
    }

    static interface C extends A {
        // Removing the method will work
        //
        // Setting default will error - will complain about D inheriting unrelated defaults for m().
        // The only way it will work is is D implements m(). See X, Y, Z below.
        //
        // Non-default will error. - because an interface method signature cannot have
        //
//        default void m() {
//            System.out.println("m() from C");
//        }
    }

    static class D implements A, B, C {
    }

    public static void main(String[] args) {
        D d = new D();
        d.m();

        // Uncomment after we discuss below interfaces
        // Z implements X & Y but overrides the method m1(),
        // so no errors/ambiguity.

//        Z z = new Z();
//        z.m1();
    }

    static interface X {
        default void m1() {
            System.out.println("Printing X.m1()");
        }
    }

    static interface Y {
        default void m1() {
            System.out.println("Printing Y.m1()");
        }
    }

    static class Z implements X, Y {
        public void m1() {
            X.super.m1();
            Y.super.m1();
        }
    }
}
