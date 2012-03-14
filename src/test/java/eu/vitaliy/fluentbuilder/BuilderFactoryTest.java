package eu.vitaliy.fluentbuilder;

import org.junit.Test;

import java.util.Arrays;

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
        Person person1 = new Person();

        person1.setFirstName(Data.FIRST_NAME);
        person1.setLastName(Data.LAST_NAME);
        person1.setAge(Data.AGE);

        //when
        Person person2 = Person.builder()
                .withFirstName(Data.FIRST_NAME)
                .withLastName(Data.LAST_NAME)
                .withAge(Data.AGE)
                .build();

        //then
        assertThat(person1).isEqualTo(person2);

    }

    @Test
    public void createBuilderWithAnnotationTest(){
//given
        PersonAnnotated person1 = new PersonAnnotated(Data.FIRST_NAME, Data.LAST_NAME, Data.AGE, Arrays.asList(Data.LOVED_THINGS_ARRAY));
        //when
        PersonAnnotated person2 = PersonAnnotated.builder()
                .withFirstName(Data.FIRST_NAME)
                .withLastName(Data.LAST_NAME)
                .withAge(Data.AGE)
                .build();

        //then
        assertThat(person1).isEqualTo(person2);

    }



}
