package eu.vitaliy.fluentbuilder;

public class Person {

    private String firstName;
    private String lastName;    
    private int age;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public interface Builder extends eu.vitaliy.fluentbuilder.Builder<Person> {
        public Builder withFirstName(String firstName);   
        public Builder withLastName(String lastName);
        public Builder withAge(int age);
    }

    public static Builder builder() {
        return BuilderFactory.createBuilder(new Person(), Builder.class);
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person1 = (Person) o;

        if (age != person1.age) return false;
        if (firstName != null ? !firstName.equals(person1.firstName) : person1.firstName != null) return false;
        if (lastName != null ? !lastName.equals(person1.lastName) : person1.lastName != null) return false;

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