package eu.vitaliy.fluentbuilder;

import org.junit.Test;
import static org.fest.assertions.Assertions.*;
/**
 * Created by IntelliJ IDEA.
 * User: xaoc
 * Date: 23.01.12
 * Time: 15:52
 * To change this template use File | Settings | File Templates.
 */
public class BuilderFactoryWithListAnnotatedTest {

    @Test
    public void createBuilderWithListWithListArgTest(){
       //given
        WithListAnnotated withList1 = new WithListAnnotated(Data.LOVED_THINGS_LIST);

        //when
        WithListAnnotated withList2 = WithListAnnotated.builder()
                .withList(Data.LOVED_THINGS_LIST)
                .build();

        //then
        assertThat(withList1).isEqualTo(withList2);

    }
}
