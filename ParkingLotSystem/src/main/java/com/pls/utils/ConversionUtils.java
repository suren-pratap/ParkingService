package com.pls.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConversionUtils {

	private static ObjectMapper objectMapper = new ObjectMapper();

	public static String getJsonString(Object obj) throws JsonProcessingException {

		return objectMapper.writeValueAsString(obj);

	}

}
