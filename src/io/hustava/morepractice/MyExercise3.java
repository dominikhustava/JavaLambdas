package io.hustava.morepractice;

import java.util.function.BiConsumer;

public class MyExercise3 {
    public static void main(String[] args) {
        int[] someNumbers = {1, 2, 3, 4, 5};
        int key = 2;

        process(someNumbers, key);

        System.out.println("---------------------");

        processFlexible(someNumbers, key, (integer, integer2) -> System.out.println(integer * integer2));
    }

    private static void process(int[] someNumbers, int key) {
        for (int i : someNumbers){
            System.out.println(i + key);
        }
    }

    private static void processFlexible(int[] someNumbers, int key, BiConsumer<Integer, Integer> consumer){
        for (int i : someNumbers) {
            consumer.accept(i, key);
        }
    }
}
