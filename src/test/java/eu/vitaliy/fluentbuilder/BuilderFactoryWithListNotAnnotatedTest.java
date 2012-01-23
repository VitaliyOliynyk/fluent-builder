package eu.vitaliy.fluentbuilder;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by IntelliJ IDEA.
 * User: xaoc
 * Date: 23.01.12
 * Time: 15:52
 * To change this template use File | Settings | File Templates.
 */
public class BuilderFactoryWithListNotAnnotatedTest {

    @Test(expected = NoSuchAnnotatedFieldException.class)
    public void createBuilderWithListWithListArgTest(){
       //given

        //when
        WithNotAnnotatedField withList = WithNotAnnotatedField.builder()
                .withFirstName(Data.FIRST_NAME)
                .build();

        //then

    }
}
