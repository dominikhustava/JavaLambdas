package io.hustava;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// java 7 way
public class MyExercise {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carrol", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person("Charlotte", "Bronte", 45),
                new Person("Matthew", "Arnold", 39));

                // Sort list be last name
                Collections.sort(people, new Comparator<>() {
                    @Override
                    public int compare(Person o1, Person o2) {
                        return o1.getLastName().compareTo(o2.getLastName());
                    }
                });
                //Create a method that prints all elements in the list
                printAll(people);
                System.out.println();

                //Create a method that prints all people that have last name beginning with C
                printLastNameBeginningWithC(people);
                System.out.println();

                //create more flexible conditional printing
                //passing behaviour via interface and anonymous implementation
                printConditionally(people, new Condition() {
                    @Override
                    public boolean test(Person p){
                        return (p.getLastName().startsWith("C"));
                    }
                });

                printConditionally(people, new Condition() {
                    @Override
                    public boolean test(Person p){
                        return (p.getFirstName().startsWith("C"));
                    }
                });




    }
    // not flexible
    private static void printLastNameBeginningWithC(List<Person> people) {
        for (Person p : people) {
            if (p.getLastName().startsWith("C")){
                System.out.println(p);
            }

        }
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

interface Condition{
    boolean test(Person p);
}