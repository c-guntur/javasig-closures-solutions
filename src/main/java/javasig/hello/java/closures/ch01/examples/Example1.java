package javasig.hello.java.closures.ch01.examples;

/**
 * Default or Extension methods.
 */
public class Example1 {
    public static void main(String[] args) {

        // Non-default methods still need to be implemented.
        MyInterface myInterface = new MyInterface() {
            @Override
            public void implementMe() {
                System.out.println("Implemented method in class");
            }
        };

        myInterface.implementMe();

        // Default methods, when invoked, will perform as implemented in the interface.
        myInterface.noNeedToImplementMe();
    }


    interface MyInterface {
        public void implementMe();

        // New in Java 8 :
        //
        // default methods allow interfaces to specify new API contracts
        // without breaking backward compatibility.
        default public void noNeedToImplementMe() {
            System.out.println("this method does not need implementing");
        }
    }

}
