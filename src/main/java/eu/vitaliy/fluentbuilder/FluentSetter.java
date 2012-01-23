package eu.vitaliy.fluentbuilder;

import java.lang.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * User: xaoc
 * Date: 23.01.12
 * Time: 13:25
 * To change this template use File | Settings | File Templates.
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface FluentSetter {
}
