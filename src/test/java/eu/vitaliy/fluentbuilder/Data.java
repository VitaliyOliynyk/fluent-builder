package eu.vitaliy.fluentbuilder;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: xaoc
 * Date: 23.01.12
 * Time: 15:47
 * To change this template use File | Settings | File Templates.
 */
public class Data {
    public final static String FIRST_NAME = "John";
    public final static String LAST_NAME = "Smith";
    public final static int AGE = 30;
    public final static String[] LOVED_THINGS_ARRAY = $("pizza", "soccer", "jogging");
    public final static List<String> LOVED_THINGS_LIST = Arrays.asList(LOVED_THINGS_ARRAY);
    public final static Collection<String> LOVED_THINGS_COLLECTION = LOVED_THINGS_LIST;



    private static <T> T[] $(T... obj){
        return obj;
    }
}
