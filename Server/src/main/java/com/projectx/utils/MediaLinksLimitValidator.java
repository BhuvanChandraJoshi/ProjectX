package com.projectx.utils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MediaLinksLimitValidator implements ConstraintValidator<MediaLinksLimit, String[]> {

    private int max;

    @Override
    public void initialize(MediaLinksLimit constraintAnnotation) {
        this.max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(String[] media, ConstraintValidatorContext context) {
        if (media == null) {
            return true; // Null values are valid; use @NotNull for non-null constraint
        }
        return media.length <= max;
    }
}
