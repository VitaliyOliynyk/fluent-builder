package eu.vitaliy.fluentbuilder;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private int age;
    private List<String> lovedThings = new ArrayList<String>();
    private String firstName;
    private String lastName;    
    
    public Person() {
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

    public void setAge(int age) {
        this.age = age;
    }

    public void setLovedThings(List<String> newbars) {
        this.lovedThings = newbars;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public interface Builder extends eu.vitaliy.fluentbuilder.Builder<Person> {
        public Builder withFirstName(String firstName);   
        public Builder withLastName(String lastName);
        public Builder withLovedThings(String... bars);
        public Builder withAge(int age);
        public Person build();
    }

    public static Builder builder() {
        return BuilderFactory.createBuilder(new Person(), Builder.class);
    }

    @Override
    public String toString() {
        return "Person{" +
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

        Person person = (Person) o;

        if (age != person.age) return false;
        if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null) return false;
        if (lastName != null ? !lastName.equals(person.lastName) : person.lastName != null) return false;
        if (lovedThings != null ? !lovedThings.equals(person.lovedThings) : person.lovedThings != null) return false;

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