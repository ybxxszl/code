package com.wjy.util;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtil {

	private static final ObjectMapper MAPPER = new ObjectMapper();

	public static String objectToJson(Object object) {
		try {
			return MAPPER.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
		try {
			return MAPPER.readValue(jsonData, beanType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> List<T> jsonToList(String jsonData, Class<T> beanType) {
		JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
		try {
			return MAPPER.readValue(jsonData, javaType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
