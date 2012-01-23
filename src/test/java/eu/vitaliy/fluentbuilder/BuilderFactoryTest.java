package eu.vitaliy.fluentbuilder;

import org.junit.Test;
import static org.fest.assertions.Assertions.*;

/**
 * Created by IntelliJ IDEA.
 * User: xaoc
 * Date: 23.01.12
 * Time: 13:08
 * To change this template use File | Settings | File Templates.
 */
public class BuilderFactoryTest {

    @Test
    public void createBuilderTest(){
        //given
        Person person = new Person();
        String firstname = "John";
        String lastName = "Smith";
        String[] lovedThings = $("pizza", "soccer", "jogging");

        person.setFirstName(firstname);
        person.setLastName(lastName);
        person.getLovedThings().add(lovedThings[0]);
        person.getLovedThings().add(lovedThings[1]);
        person.getLovedThings().add(lovedThings[2]);
        person.setAge(30);

        Person person2 = Person.builder()
                .withFirstName(firstname)
                .withLastName(lastName)
                .withLovedThings(lovedThings)
                .withAge(30)
                .build();

        assertThat(person.equals(person2)).isTrue();

    }


    private static <T> T[] $(T... obj){
        return obj;
    }
}
