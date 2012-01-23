package eu.vitaliy.fluentbuilder;

/**
 * Created by IntelliJ IDEA.
 * User: xaoc
 * Date: 23.01.12
 * Time: 16:12
 * To change this template use File | Settings | File Templates.
 */
public class FluentBuilderException extends RuntimeException {
    public FluentBuilderException() {
    }

    public FluentBuilderException(String s) {
        super(s);
    }

    public FluentBuilderException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public FluentBuilderException(Throwable throwable) {
        super(throwable);
    }
}
