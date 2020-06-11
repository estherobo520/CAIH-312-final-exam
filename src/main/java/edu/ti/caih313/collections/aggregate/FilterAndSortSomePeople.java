package edu.ti.caih313.collections.aggregate;

import edu.ti.caih313.collections.dataobj.Name;
import edu.ti.caih313.collections.dataobj.Person;

import java.beans.FeatureDescriptor;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.stream.Stream;

import static edu.ti.caih313.collections.dataobj.Person.Gender.*;

public class FilterAndSortSomePeople {
    public static void main(String... args) {
        Person personArray[] = {
                new Person(new Name("John", "Smith"), MALE, LocalDate.of(1978, Month.MARCH, 15)),
                new Person(new Name("Karl", "Ng"), MALE, LocalDate.of(1948, Month.JANUARY, 3)),
                new Person(new Name("Jeff", "Smith"), MALE, LocalDate.of(1998, Month.MAY, 13)),
                new Person(new Name("Tom", "Rich"), MALE, LocalDate.of(2003, Month.MAY, 13)),
                new Person(new Name("Bob", "Smith"), MALE, LocalDate.of(2007, Month.APRIL, 1)),
                new Person(new Name("Jane", "Doe"), FEMALE, LocalDate.of(1993, Month.OCTOBER, 30)),
                new Person(new Name("Tony", "Stark"), MALE, LocalDate.of(1968, Month.JULY, 16)),
                new Person(new Name("Bo", "Peep"), FEMALE, LocalDate.of(1624, Month.FEBRUARY, 23))
        };

        long numMalesUnder40 = Arrays.stream(personArray).filter(p -> (p.getAge() < 40) && (p.getGender() == MALE)).count();
        System.out.println("Number of males under 40: " + numMalesUnder40);

        System.out.print("\n");
        System.out.println("All FEMALEs in reverse (oldest to youngest) age order");
        Arrays.stream(personArray)
                .filter(p -> p.getGender() == FEMALE)
                .sorted((p1,p2) -> (int) (p2.getAge() - p1.getAge()))
                .forEach(e -> System.out.println(e.getName().getFirstName() + " " + e.getName().getLastName()));
    }
}
