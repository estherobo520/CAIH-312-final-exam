package edu.ti.caih313.collections.dataobj;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Person {
    private Name name;
    private Gender gender;

    private EmailAddress emailAddress;

    private LocalDate birthDate;

    public enum Gender {MALE, FEMALE}

    public Person(Name name, Gender gender, LocalDate birthDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public Integer getAge() {
        Period ageNow = Period.between(birthDate, LocalDate.now());
        return ageNow.getYears();
    }

    @Override
    public String toString() {

        String emailAddressString;
        if (emailAddress == null) {
            emailAddressString = "no email address available";
        } else {
            emailAddressString = emailAddress.getEmailAddress();
        }
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d, yyyy 'C.E.'");
        String birthDateString = birthDate.format(format);

        String nameFormattedString =String.format("name is %s",name);
        String genderFormattedString =String.format("gender is %s",gender);
        String emailAddressFormattedString=String.format("emailAddress is %s",emailAddressString);
        String birthDateFormattedString=String.format("birth date is %s",birthDateString);
        String ageFormattedString=String.format("age is %x", getAge());

        return "Person: " + nameFormattedString + genderFormattedString + emailAddressFormattedString + birthDateFormattedString + ageFormattedString + "";

    }
}
