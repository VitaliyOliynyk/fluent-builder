package eu.vitaliy.fluentbuilder;

/**
 * Created by IntelliJ IDEA.
 * User: xaoc
 * Date: 23.01.12
 * Time: 15:28
 * To change this template use File | Settings | File Templates.
 */
public class WithNotAnnotatedField {

    private String firstName;

    public WithNotAnnotatedField() {
    }

    public interface Builder extends eu.vitaliy.fluentbuilder.Builder<WithNotAnnotatedField> {
        public Builder withFirstName(String list);
    }

     public static Builder builder() {
        return BuilderFactory.createBuilder(new WithNotAnnotatedField(), Builder.class);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WithNotAnnotatedField that = (WithNotAnnotatedField) o;

        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return firstName != null ? firstName.hashCode() : 0;
    }
}
