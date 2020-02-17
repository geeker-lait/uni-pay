package com.unichain.pay.gateway.annotation;

import java.lang.annotation.*;

/**
 * @ClassName Access
 * @Author http://github.com/geeker-lait
 * @Tel 15801818092
 * @Date 11:11 AM 9/27/2018
 * @Version 1.0.0
 * @Description //TODO
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Access {
    boolean value() default true;
}
