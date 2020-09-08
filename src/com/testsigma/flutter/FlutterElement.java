package com.testsigma.flutter;

import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;

import java.util.Base64;
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
	private Map<String, Object> rawMap;
	private String id;
	private final Gson gson = new Gson();

	public FlutterElement(Map<String, Object> rawMap) {
		this.rawMap = rawMap;
		id = serialize(rawMap);
	}

	public Map<String, ?> getRawMap() {
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
		String base64Encoded = Base64.getEncoder().encodeToString(mapJsonStringified.getBytes());
		return base64Encoded;
	}

	public Map<String, Object> deserialize(String base64Encoded){
		try{
			String base64Decoded = Base64.getDecoder().decode(base64Encoded).toString();
			Map rawMap = gson.fromJson(base64Encoded, Map.class);
		}catch (JsonSyntaxException jsonsyntaxExc){
			jsonsyntaxExc.printStackTrace();
			rawMap.put("empty","empty");
		}
		return rawMap;
	}
}