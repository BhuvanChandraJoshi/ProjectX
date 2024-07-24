package com.projectx.utils;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.Arrays;
import java.util.stream.Collectors;


//This class convert a string array into a long delimited (via ',') string
@Converter(autoApply = true)
public class StringArrayConverter implements AttributeConverter<String[], String> {

    @Override
    public String convertToDatabaseColumn(String[] attribute) {
        if (attribute == null) {
            return null;
        }
        // Convert the array to a single string with comma-separated values
        return Arrays.stream(attribute)
                .collect(Collectors.joining(","));
    }

    @Override
    public String[] convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return new String[0];
        }
        // Convert the string back to an array by splitting on commas
        return dbData.split(",");
    }
}

