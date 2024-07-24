package com.projectx.utils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MediaSizeValidator implements ConstraintValidator<MediaSize, String[]> {

    private int max;

    @Override
    public void initialize(MediaSize constraintAnnotation) {
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
