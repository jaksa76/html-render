package me.jaksa.web.htmlrender;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.stream.Stream;

class ClassUtils {
    public static Object getValue(Object o, Field f) {
        boolean accessible = f.isAccessible();
        try {
            f.setAccessible(true);
            return f.get(o);
        } catch (IllegalAccessException e) {
            return e.getMessage();
        } finally {
            f.setAccessible(accessible);
        }
    }

    public static Stream<Field> getFields(Object o) {
        return getFields(o.getClass());
    }

    public static Stream<Field> getFields(Class cls) {
        return Stream.of(cls.getDeclaredFields());
    }

    public static Stream<String> getFieldNames(Class cls) {
        return getFields(cls).map(f -> f.getName());
    }

    public static Stream<Field> getFieldsRecursively(Class cls) {
        Stream.Builder<Field> builder = Stream.builder();
        addFieldsRecursively(cls, builder);
        return builder.build();
    }

    private static void addFieldsRecursively(Class cls, Stream.Builder<Field> builder) {
        getFields(cls).forEach(f -> {
            if (isSimple(f.getClass())) builder.accept(f);
            else addFieldsRecursively(f.getClass(), builder);
        });
    }

    public static boolean isSimple(Class<?> cls) {
        return org.apache.commons.lang3.ClassUtils.isPrimitiveOrWrapper(cls) || cls.equals(String.class);
    }

    public static boolean isCollection(Class<?> cls) {
        return Collection.class.isAssignableFrom(cls);
    }
}
