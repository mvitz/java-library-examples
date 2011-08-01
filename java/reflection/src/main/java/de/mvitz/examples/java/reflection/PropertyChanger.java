package de.mvitz.examples.java.reflection;

import java.lang.reflect.Method;
import java.util.Collection;

public final class PropertyChanger<T> {

    private final Class<T> clazz;

    public PropertyChanger(Class<T> clazz) {
        this.clazz = clazz;
    }

    public void changePropertyForEvery(Collection<T> beans, String property, Object newValue)
            throws Exception {
        final String methodName = setterFor(property);
        final Method method = clazz.getMethod(methodName, newValue.getClass());
        for (T bean : beans) {
            method.invoke(bean, newValue);
        }
    }

    private String setterFor(String property) {
        final String firstCharacter = property.substring(0, 1);
        return "set" + firstCharacter.toUpperCase() + property.substring(1);
    }

}
