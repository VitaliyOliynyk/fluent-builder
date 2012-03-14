Fluent builder, project inspired by http://www.andreafrancia.it/articoli/fluent-builder/

### Use it like this:
```
public class Person {

    @FluentSetter
    private int age;

    @FluentSetter
    private String firstName;

    @FluentSetter
    private String lastName;

    private Person() {
    }

    public interface Builder extends eu.vitaliy.fluentbuilder.Builder<Person> {
        public Builder withFirstName(String firstName);
        public Builder withLastName(String lastName);
        public Builder withAge(int age);
    }

    public static Builder builder() {
        return BuilderFactory.createBuilder(new Person(), Builder.class);
    }
 }

 class Main{
        public static void main(String[] args){
            Person person = Person.builder()
                .withFirstName("Jan")
                .withLastName("Kowalski")
                .withAge(33)
                .build();
        }
 }

```