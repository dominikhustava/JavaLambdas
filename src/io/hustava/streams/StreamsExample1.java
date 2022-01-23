package io.hustava.streams;

import io.hustava.Person;

import java.util.Arrays;
import java.util.List;

public class StreamsExample1 {
    //Analogy: Cars and mechanincs. Each one looping around each car vs something like assembly line

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carrol", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person("Charlotte", "Bronte", 45),
                new Person("Matthew", "Arnold", 39));

        //dont think of these people like objects in horizontal line [1][2][3][4][5], think of them like verical assembly line
        people.stream()
                .filter(p -> p.getLastName().startsWith("C"))
                .forEach(p -> System.out.println(p.getFirstName()));
    }

}
