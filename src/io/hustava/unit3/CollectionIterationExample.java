package io.hustava.unit3;

import io.hustava.Person;

import java.util.Arrays;
import java.util.List;

public class CollectionIterationExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carrol", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person("Charlotte", "Bronte", 45),
                new Person("Matthew", "Arnold", 39));

        System.out.println("Using for loop");
        for (int i = 0; i < people.size(); i++){
            System.out.println(people.get(i));
        }

        System.out.println("Using for in loop");
        for (Person p:
             people) {
            System.out.println(p);
        }

        System.out.println("Using foreach loop");
        //people.forEach(p -> System.out.println(p));
        people.forEach(System.out::println);

        //first two are external iterators (I'm in controll of looping) //not good for parallel computing
        //last is internal iterator

        //advantage of the last is that it's better for parallel computing, to run it in multiple threads

    }
}
