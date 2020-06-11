package edu.ti.caih313.collections.dataobj;

import java.util.Objects;

public class Name {
    private final String firstName;
    private final String lastName;

    public Name(String firstName, String lastName) {
        if (firstName == null || lastName == null) {
            throw new IllegalArgumentException("Both first and last name must be specified.");
        }
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return firstName.equals(name.firstName) &&
                lastName.equals(name.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {

        StringBuilder emailStringBuilder = new StringBuilder("");
        if(firstName == null && lastName == null) {
            emailStringBuilder.append("no full name available");
        }
        if (getFirstName() != null) {
            emailStringBuilder.append("First name: " + getFirstName() + ".");
        }
        else{
            emailStringBuilder.append("No first name available");
        }

        if (getLastName() != null) {
            emailStringBuilder.append("Last name: " + getLastName() + ".");
        }
        else{
            emailStringBuilder.append("No last name available");
        }
        return emailStringBuilder.toString();
    }
}
