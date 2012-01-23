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

    public static final String FIRST_NAME = "John";
    public static final String LAST_NAME = "Smith";
    public static final String[] LOVED_THINGS = $("pizza", "soccer", "jogging");
    public static final int AGE = 30;

    @Test
    public void createBuilderTest(){
        //given
        Person1 person1 = new Person1();

        person1.setFirstName(FIRST_NAME);
        person1.setLastName(LAST_NAME);
        person1.getLovedThings().add(LOVED_THINGS[0]);
        person1.getLovedThings().add(LOVED_THINGS[1]);
        person1.getLovedThings().add(LOVED_THINGS[2]);
        person1.setAge(AGE);

        //when
        Person1 person2 = Person1.builder()
                .withFirstName(FIRST_NAME)
                .withLastName(LAST_NAME)
                .withLovedThings(LOVED_THINGS)
                .withAge(AGE)
                .build();

        //then
        assertThat(person1.equals(person2)).isTrue();

    }

    @Test
    public void createBuilderWithAnnotationTest(){
//given
        Person2 person1 = new Person2(FIRST_NAME, LAST_NAME, AGE, Arrays.asList(LOVED_THINGS));

        //when
        Person1 person2 = Person1.builder()
                .withFirstName(FIRST_NAME)
                .withLastName(LAST_NAME)
                .withLovedThings(LOVED_THINGS)
                .withAge(AGE)
                .build();

        //then
        assertThat(person1.equals(person2)).isTrue();

    }


    private static <T> T[] $(T... obj){
        return obj;
    }
}
