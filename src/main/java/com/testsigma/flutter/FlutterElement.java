package com.testsigma.flutter;

import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import io.appium.java_client.MobileElement;

import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * Implement FlutterElement extending MobileElement to enable
 * common Mobile element operations such as click, enter e.t.c
 * on FlutterElement objects
 *
 * @author renju
 * @version 0.1
 */

public class FlutterElement extends MobileElement{
	private final Map<String,String> rawMap;
	private final Gson gson = new Gson();

	public FlutterElement(ImmutableMap<String, String> rawMap)
	{
		this.rawMap = rawMap;
		String id = serialize(rawMap);
	}

	public Map<String, String> getRawMap() {
		return rawMap;
	}

	public String serialize(Map<String, ?> rawMap) {
		final JsonPrimitive INSTANCE = new JsonPrimitive(false);
		Map<String, Object> tempMap = ImmutableMap.of();
		rawMap.forEach(
				(key, value) -> {
					if (value instanceof String || value instanceof Integer || value instanceof Boolean) {
						tempMap.put(key, new JsonPrimitive((String) value));
					} else if (value instanceof JsonElement) {
						tempMap.put(key, value);
					} else {
						tempMap.put(key, INSTANCE);
					}
				});
		String mapJsonStringified = gson.toJson(tempMap);
		return Base64.getEncoder().encodeToString(mapJsonStringified.getBytes());
	}
}