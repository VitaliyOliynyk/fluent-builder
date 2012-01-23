package eu.vitaliy.fluentbuilder;

import java.beans.Expression;
import java.beans.Statement;
import java.lang.reflect.Field;
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
                throw new TooManyArgumentsException(args);
            }
            String propertyName = method.getName().substring("with".length());

            String setter = "set" + propertyName;
            Statement stmt = new Statement(this.obj, setter, args);
            try{
                stmt.execute();
            }catch(NoSuchMethodException ex){
                handleAnnotation(args[0], propertyName);
            }
            return proxy;
        }

        private void handleAnnotation(Object arg, String propertyName) throws NoSuchFieldException, IllegalAccessException {
            String fieldName = Character.toLowerCase(propertyName.charAt(0)) + propertyName.substring(1);
            Field field = obj.getClass().getDeclaredField(fieldName);
            if(field.isAnnotationPresent(FluentSetter.class))
            {
                field.setAccessible(true);
                field.set(obj, arg);
            }else{
                throw new NoSuchAnnotatedFieldException(field);
            }
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