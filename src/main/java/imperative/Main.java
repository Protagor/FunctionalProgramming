package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.function.*;

import static imperative.Main.Gender.*;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Günther", MALE),
                new Person("Michael", MALE),
                new Person("Ann", FEMALE),
                new Person("Siri", FEMALE)
        );

        System.out.println("Imperative approach");
        // Imperative approach
        List<Person> females = new ArrayList<>();

        for (Person person : people) {
            if (FEMALE.equals(person.gender)) {
                females.add(person);
            }
        }

        for (Person female : females) {
            System.out.println(female.name);
        }

        System.out.println("Declarative approach");
        // Declarative approach
        Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);

        List<Person> females2 = people.stream()
                .filter(personPredicate)
                .collect(Collectors.toList());

        females2.forEach(female -> System.out.println(female.name));
    }

    public static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }
    }

    enum Gender {
        MALE, FEMALE
    }
}
