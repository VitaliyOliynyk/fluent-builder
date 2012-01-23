package eu.vitaliy.fluentbuilder;

import java.util.List;

public class PersonAnnotated {

    @FluentSetter
    private int age;

    @FluentSetter
    private String firstName;

    @FluentSetter
    private String lastName;

    public PersonAnnotated() {
    }


    public PersonAnnotated(String firstName, String lastName, int age, List<String> lovedThings) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public interface Builder extends eu.vitaliy.fluentbuilder.Builder<PersonAnnotated> {
        public Builder withFirstName(String firstName);   
        public Builder withLastName(String lastName);
        public Builder withAge(int age);
        public PersonAnnotated build();
    }

    public static Builder builder() {
        return BuilderFactory.createBuilder(new PersonAnnotated(), Builder.class);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonAnnotated person2 = (PersonAnnotated) o;

        if (age != person2.age) return false;
        if (firstName != null ? !firstName.equals(person2.firstName) : person2.firstName != null) return false;
        if (lastName != null ? !lastName.equals(person2.lastName) : person2.lastName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }
}