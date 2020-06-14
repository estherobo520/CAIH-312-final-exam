package edu.ti.caih313.collections.dataobj;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static junit.framework.TestCase.assertEquals;

public class PersonTest {
    Person test;
    EmailAddress testEmail;
    @Test
    public void testPersonToString(){
        test = new Person(new Name("TestFirst", "TestLast"), Person.Gender.MALE, LocalDate.of(1999, Month.MAY, 20));
        testEmail = new EmailAddress("testEmail@gmail.com", EmailAddress.Type.HOME);
        test.setEmailAddress(testEmail);

        String testToString = test.toString();
        assertEquals("Person {Name = First name: TestFirst.Last name: TestLast., Gender = MALE, Birth Date = May 20, 1999 C.E., Email Address = testEmail@gmail.com}", testToString);
    }
}
