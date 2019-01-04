package com.team.gallery.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;

public class MediaUtil {
	private static Map<String, MediaType> mediaMap;
	
	static {
		mediaMap = new HashMap<String, MediaType>();
		
		mediaMap.put("JPG", MediaType.IMAGE_JPEG);
		mediaMap.put("GIF", MediaType.IMAGE_GIF);
		mediaMap.put("PNG", MediaType.IMAGE_PNG);
	}
	
	public static MediaType getMediaType(String type) {
		
		String formatName =getFromatName(type);
		
		return mediaMap.get(formatName);
	}
	
	static String getFromatName(String fileName) {
		return fileName.substring(fileName.lastIndexOf(".")+1).toUpperCase();
	}
}
