package javasig.hello.java.closures.ch01.examples;

/**
 * Custom functional interfaces - Single Abstract Method (SAM) type.
 */
public class Example7 {
    public static void main(String[] args) {
        Example7 demo = new Example7();

        //Classic Style
        ConstantReturner answerToLifeClassic = new ConstantReturner() {
            @Override
            public int returnConstant() {
                return 42;
            }
        };

        System.out.println("The answer to life is : " + answerToLifeClassic.returnConstant());

        //Java 8 Style
        ConstantReturner answerToLife = () -> 42;
        System.out.println("The answer to life is : " + answerToLife.returnConstant());
        answerToLife.printResult();
    }

    private static interface ConstantReturner {
        public int returnConstant();

        default public void printResult() {
            System.out.println("The constant returned is: "+ returnConstant());
        }
    }

}