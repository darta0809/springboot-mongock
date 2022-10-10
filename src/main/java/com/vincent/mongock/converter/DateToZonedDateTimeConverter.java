package com.vincent.mongock.converter;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

@ReadingConverter
public enum DateToZonedDateTimeConverter implements Converter<Date, ZonedDateTime> {
  INSTANCE;

  @Override
  public ZonedDateTime convert(Date source) {
    return ZonedDateTime.ofInstant(source.toInstant(), ZoneId.systemDefault());

  }
}