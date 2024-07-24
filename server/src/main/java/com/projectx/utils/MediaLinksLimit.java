package com.projectx.utils;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


//This is a custom annotation, used in Post class for storing and validation of media links

@Constraint(validatedBy = MediaLinksLimitValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface MediaLinksLimit {
    String message() default "The number of media links must not exceed {max}";
    int max() default 10;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
