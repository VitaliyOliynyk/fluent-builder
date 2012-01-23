package eu.vitaliy.fluentbuilder;

import java.lang.reflect.Field;

/**
 * Created by IntelliJ IDEA.
 * User: xaoc
 * Date: 23.01.12
 * Time: 16:19
 * To change this template use File | Settings | File Templates.
 */
public class NoSuchAnnotatedFieldException extends FluentBuilderException {
    private Field field;
    public NoSuchAnnotatedFieldException(Field field) {
        super();
        this.field = field;
    }

    public Field getField() {
        return field;
    }
}
