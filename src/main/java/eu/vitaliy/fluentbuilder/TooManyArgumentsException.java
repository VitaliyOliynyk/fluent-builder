package eu.vitaliy.fluentbuilder;

/**
 * Created by IntelliJ IDEA.
 * User: xaoc
 * Date: 23.01.12
 * Time: 16:13
 * To change this template use File | Settings | File Templates.
 */
public class TooManyArgumentsException extends FluentBuilderException{
    Object[] args;

    public TooManyArgumentsException(Object[] args) {
        this.args = args;
    }

    public Object[] getArgs() {
        return args;
    }
}
