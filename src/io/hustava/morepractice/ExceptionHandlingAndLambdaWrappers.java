package io.hustava.morepractice;

import java.util.function.BiConsumer;

public class ExceptionHandlingAndLambdaWrappers {

    public static void main(String[] args) {
        int[] someNumbers = {1, 2, 0, 4, 5};
        int key = 0;

        process(someNumbers, key);

        System.out.println("---------------------");
        processFlexible(someNumbers, key, (integer, integer2) -> System.out.println(integer / integer2));

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
    }

    private static void process(int[] someNumbers, int key) {
        for (int i : someNumbers){
            System.out.println(i + key);
        }
    }

    //we don't know what to handle behaviour is passing to us. We can handle generic exception, or have long list of catch blocks
    private static void processFlexible(int[] someNumbers, int key, BiConsumer<Integer, Integer> consumer){
        for (int i : someNumbers) {
            try {
                consumer.accept(i, key);
            }catch (Exception e){
                System.out.println(" some exception happend");
            }
        }
    }

}
