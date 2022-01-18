package io.hustava;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class StandardFunctionalInterfacesExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carrol", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person("Charlotte", "Bronte", 45),
                new Person("Matthew", "Arnold", 39));

        // Sort list be last name
        Collections.sort(people, ((p1, p2) -> p1.getLastName().compareTo(p2.getLastName()) ));

        //Create a method that prints all elements in the list
        printConditionally(people, p -> true, p -> System.out.println(p));
        System.out.println();

        //Create a method that prints all people that have last name beginning with C using lambda
        printConditionally(people, (p) -> p.getLastName().startsWith("C"), p -> System.out.println(p));
        System.out.println("---------------------------------------");
        printConditionally(people, p -> p.getFirstName().startsWith("C"), person -> System.out.println(person.getFirstName()));


    }
    private static void printConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
        for (Person p : people) {
            if (predicate.test(p)){
                consumer.accept(p);
            }

        }
    }


}
