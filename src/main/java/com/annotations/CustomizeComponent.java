package com.annotations;

import java.lang.annotation.*;
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CustomizeComponent {
  String value() default "";
}