package com.thejoyrun.aptpreferences;

import java.lang.reflect.Type;

/**
 * Created by Wiki on 16/7/16.
 */
public interface AptParser {

    Object deserialize(Type type, String text);

    String serialize(Object object);
}
