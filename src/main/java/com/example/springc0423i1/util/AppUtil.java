package com.example.springc0423i1.util;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AppUtil {
    public static final ModelMapper mapper;

    static {
        mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Converter<String, LocalDate> toStringDate = new AbstractConverter<>() {
            @Override
            protected LocalDate convert(String source) {
                DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                return LocalDate.parse(source, format);
            }
        };
        Converter<String, LocalDateTime> toStringDateTime = new AbstractConverter<>() {
            @Override
            protected LocalDateTime convert(String source) {
                DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
                return LocalDateTime.parse(source, format);
            }
        };
        Converter<LocalDateTime, LocalTime> toTimeDateTime = new AbstractConverter<>() {
            @Override
            protected LocalTime convert(LocalDateTime source) {
                return source.toLocalTime();
            }
        };





        mapper.createTypeMap(String.class, LocalDate.class);
        mapper.addConverter(toStringDate);
        mapper.addConverter(toStringDateTime);
        mapper.addConverter(toTimeDateTime);
    }
}
