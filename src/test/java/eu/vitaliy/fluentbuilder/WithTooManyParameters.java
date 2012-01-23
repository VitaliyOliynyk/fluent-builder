package eu.vitaliy.fluentbuilder;

/**
 * Created by IntelliJ IDEA.
 * User: xaoc
 * Date: 23.01.12
 * Time: 15:28
 * To change this template use File | Settings | File Templates.
 */
public class WithTooManyParameters {

    private String firstName;

    public WithTooManyParameters() {
    }

    public interface Builder extends eu.vitaliy.fluentbuilder.Builder<WithTooManyParameters> {
        public Builder withFirstName(String arg1, String arg2);
    }

     public static Builder builder() {
        return BuilderFactory.createBuilder(new WithTooManyParameters(), Builder.class);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WithTooManyParameters that = (WithTooManyParameters) o;

        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return firstName != null ? firstName.hashCode() : 0;
    }
}
