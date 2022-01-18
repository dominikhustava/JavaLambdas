package io.hustava;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//java 8 way with lambdas
public class MyExercise2 {

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
        printAll(people);
        System.out.println();

        //Create a method that prints all people that have last name beginning with C using lambda
        printConditionally(people, (p) -> p.getLastName().startsWith("C"));
        System.out.println("---------------------------------------");
        printConditionally(people, p -> p.getFirstName().startsWith("C"));



}
    private static void printConditionally(List<Person> people, Condition condition) {
        for (Person p : people) {
            if (condition.test(p)){
                System.out.println(p);
            }

        }
    }


    private static void printAll(List<Person> people){
        for (Person p : people) {
            System.out.println(p);
        }
    }
}
