package eu.vitaliy.fluentbuilder;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: xaoc
 * Date: 23.01.12
 * Time: 15:28
 * To change this template use File | Settings | File Templates.
 */
public class WithListAnnotated {

    @FluentSetter
    private List<String> list;

    public WithListAnnotated() {
    }

    public WithListAnnotated(List<String> list) {
        this.list = list;
    }

    public interface Builder extends eu.vitaliy.fluentbuilder.Builder<WithListAnnotated> {
        public Builder withList(List<String> list);
        public Builder withList(String... firstName);
    }

     public static Builder builder() {
        return BuilderFactory.createBuilder(new WithListAnnotated(), Builder.class);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WithListAnnotated withList = (WithListAnnotated) o;

        if (list != null ? !list.equals(withList.list) : withList.list != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return list != null ? list.hashCode() : 0;
    }
}
