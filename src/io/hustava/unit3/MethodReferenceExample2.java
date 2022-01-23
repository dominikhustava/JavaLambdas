package io.hustava.unit3;

import io.hustava.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MethodReferenceExample2 {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carrol", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person("Charlotte", "Bronte", 45),
                new Person("Matthew", "Arnold", 39));

        //Lambda way
        printConditionally(people, p -> p.getFirstName().startsWith("C"), p -> System.out.println(p));

        //Method reference way
        printConditionally(people, p -> p.getFirstName().startsWith("C"), System.out::println);
        //It knows that one argument is taken from method signature argument - eg: Consumer takes one argument.
        //System.out is instance, so we are calling instance method, not static method as in MethodReferenceExample

    }
    private static void printConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
        for (Person p : people) {
            if (predicate.test(p)){
                consumer.accept(p);
            }

        }
    }
}

