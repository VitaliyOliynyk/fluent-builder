package eu.vitaliy.fluentbuilder;

import java.beans.Expression;
import java.beans.Statement;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;

public class BuilderFactory {

    private static class BuilderHandler<T> implements InvocationHandler {

        private T obj;

        public BuilderHandler(T obj) {
            this.obj = obj;
        }

        @SuppressWarnings("unchecked")
        public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
            if ("build".equals(method.getName())) {
                return obj;
            } else if (method.getName().startsWith("with")) {
                return handleWithPrefixMethod(proxy, method, args);
            } else {
                throw new UnsupportedOperationException(method.toString());
            }
        }

        private Object handleWithPrefixMethod(Object proxy, Method method, Object[] args) throws Exception {
            if(method.getParameterTypes().length !=1) {
                throw new UnsupportedOperationException();
            }
            String propertyName = method.getName().substring("with".length());

            if(method.getParameterTypes()[0].isArray()) {
                handleArrayArgument(args[0], propertyName);
            } else {
                String setter = "set" + propertyName;
                Statement stmt = new Statement(this.obj, setter, args);
                stmt.execute();
            }
            return proxy;
        }

        private void handleArrayArgument(Object arg, String propertyName) throws Exception {
            String listGetterName = "get" + propertyName;
            Expression listGetterMethod = new Expression(this.obj, listGetterName, null);
            listGetterMethod.execute();
            List list = (List) listGetterMethod.getValue();
            list.clear();
            list.addAll(Arrays.asList((Object[]) arg));
        }
    }

    public static <T,V extends Builder<T>> V createBuilder(T object, Class<V> builderInterface) 
    {
        
        BuilderHandler<T> handler = new BuilderHandler<T>(object);

        @SuppressWarnings("unchecked")
        V builder = (V) Proxy.newProxyInstance(
                builderInterface.getClassLoader(),
                new Class[]{builderInterface},
                handler);
        return builder;
    }
}  