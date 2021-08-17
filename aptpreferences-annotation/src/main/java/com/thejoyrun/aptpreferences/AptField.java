package com.thejoyrun.aptpreferences;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解说明该方法是通过commit实时提交的
 * Created by Wiki on 16/7/15.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface AptField {

    /**
     * 不持久化该字段，仅仅保留在内存
     * true：保存 false：只保留在内存
     */
    boolean save() default true;

    /**
     * true:commit提交
     * false:apply提交
     * 因为在MMKV中commit和apply的实现是没有区别的，且再AptMMapProcessor中是没有区分的，
     * 所以在使用@AptMMap的时候不建议使用
     */
    @Deprecated
    boolean commit() default false;

//    boolean force() default false;

    /**
     * true:使用preferences的方式保存
     * false:将对象转为json再以字符串形式保存
     * @return
     */
    boolean preferences() default false;

    /**
     * 如果是true全局参数通过get(name1)或者get(name2)使用都是一样的,如果是false,那么字段名会带上name(name1_fieldName)
     *
     * @return
     */
    boolean global() default true;
}