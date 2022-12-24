package com.example.mentoring.common.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
public class LocalTimeConverter implements Converter<String, LocalTime> {

    private final DateTimeFormatter dateTimeFormatter;

    public LocalTimeConverter(){
        this.dateTimeFormatter = DateTimeFormatter.ofPattern("HH:MM");
    }

    @Override
    public LocalTime convert(String stringTime){
        return LocalTime.parse(stringTime, dateTimeFormatter);
    }

}
