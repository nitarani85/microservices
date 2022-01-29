package com.example.historyms.entity;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;


@Converter
public class StringSetConverter implements AttributeConverter<Set<String>, String> {
	  @Override
	  public String convertToDatabaseColumn(Set<String> list) {
	    return String.join(",", list); 
	  }

	  @Override
	  public Set<String> convertToEntityAttribute(String joined) {
	    return new HashSet<>(Arrays.asList(joined.split(",")));
	  }

}