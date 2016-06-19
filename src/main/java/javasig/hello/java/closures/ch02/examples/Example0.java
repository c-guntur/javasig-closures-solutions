package javasig.hello.java.closures.ch02.examples;

import java.util.stream.IntStream;

/**
 * Understanding streams
 */
public class Example0 {
    public static void main(String[] args) {
        // What does this do? - Why?
        IntStream.range(1, 10)
                .peek(System.out::println)
                .peek(i -> {
                    if (i > 5)
                        throw new RuntimeException("uh oh !!!");
                });

    }
}
