package com.thejoyrun.aptpreferences;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class TypeReference<T> {
    private final Type type;
    public static final Type LIST_STRING = (new TypeReference<List<String>>() {
    }).getType();

    protected TypeReference() {
        Type superClass = this.getClass().getGenericSuperclass();
        this.type = ((ParameterizedType)superClass).getActualTypeArguments()[0];
    }

    public Type getType() {
        return this.type;
    }
}