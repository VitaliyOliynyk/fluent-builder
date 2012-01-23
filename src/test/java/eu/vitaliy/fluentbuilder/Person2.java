package eu.vitaliy.fluentbuilder;

import java.util.ArrayList;
import java.util.List;

public class Person2 {

    @FluentSetter
    private int age;

    @FluentSetter
    private List<String> lovedThings = new ArrayList<String>();

    @FluentSetter
    private String firstName;

    @FluentSetter
    private String lastName;

    public Person2() {
    }


    public Person2(String firstName, String lastName, int age, List<String> lovedThings) {
        this.age = age;
        this.lovedThings = lovedThings;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public List<String> getLovedThings() {
        return this.lovedThings;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public interface Builder extends eu.vitaliy.fluentbuilder.Builder<Person2> {
        public Builder withFirstName(String firstName);   
        public Builder withLastName(String lastName);
        public Builder withLovedThings(String... bars);
        public Builder withAge(int age);
        public Person2 build();
    }

    public static Builder builder() {
        return BuilderFactory.createBuilder(new Person2(), Builder.class);
    }

    @Override
    public String toString() {
        return "Person2{" +
                "age=" + age +
                ", lovedThings=" + lovedThings +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person2 person2 = (Person2) o;

        if (age != person2.age) return false;
        if (firstName != null ? !firstName.equals(person2.firstName) : person2.firstName != null) return false;
        if (lastName != null ? !lastName.equals(person2.lastName) : person2.lastName != null) return false;
        if (lovedThings != null ? !lovedThings.equals(person2.lovedThings) : person2.lovedThings != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + (lovedThings != null ? lovedThings.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }
}