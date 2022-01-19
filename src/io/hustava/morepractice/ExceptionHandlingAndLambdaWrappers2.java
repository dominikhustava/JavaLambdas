package io.hustava.morepractice;

import java.util.function.BiConsumer;

public class ExceptionHandlingAndLambdaWrappers2 {

    public static void main(String[] args) {
        int[] someNumbers = {1, 2, 0, 4, 5};
        int key = 0;

        //System.out.println("---------------------");
        processFlexible(someNumbers, key, (v, k) -> System.out.println(v / k));

        //not pretty solution, but executes every iteration without breaking, handling exceptions at passing time, so we know what to handle
        processFlexible(someNumbers, key,
                (v, k) -> {
                    try {
                        System.out.println(v / k);
                    }catch(ArithmeticException ae){
                        System.out.println("An Arithmetic exception happend");
                    }
                }
        );

        //I could externalized the try catch to another function and wrap the main lambda with wrapper lambda



        processFlexible(someNumbers, key, wrapperLambdaMethod((v, k) -> System.out.println(v / k) ));

    }
    //it need to accept lambdas functional interface, do nothing(no-op) function, passthru fction.
    //I personally dont like this solution, one possible way of enhancement is to make it generic, but it still looks like delegation
    private static BiConsumer<Integer, Integer> wrapperLambdaMethod(BiConsumer<Integer, Integer> consumer){
        //return consumer;
        return (v, k) -> {
            try {
                consumer.accept(v, k);
            }catch (ArithmeticException e){
                System.out.println("Exception caught in wrapper lambda");
            }
        };
    }

    private static void processFlexible(int[] someNumbers, int key, BiConsumer<Integer, Integer> consumer){
        for (int i : someNumbers) {
                consumer.accept(i, key);
        }
    }

}
