package com.thejoyrun.aptpreferences;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Wiki on 16/7/15.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Deprecated
public @interface AptPreferences {
    //SharePreferences存在效率偏低问题，建议使用MMAP(@AptMMap)实现数据持久化
}
