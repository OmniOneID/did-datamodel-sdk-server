/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.enums.provider;

import java.util.EnumSet;

public enum LogoImageType {
	JPG("jpg"),
	PNG("png");

	private String rawValue;

	LogoImageType(String rawValue) {
		this.rawValue = rawValue;
	}


	public String getRawValue() {
		return rawValue;
	}
	
	public static LogoImageType fromString(String text) {
		for (LogoImageType b : LogoImageType.values()) {
			if (b.rawValue.equalsIgnoreCase(text)) {
				return b;
			}
		}
		return null;
	}

	public static EnumSet<LogoImageType> all() {
		return EnumSet.allOf(LogoImageType.class);
	}

}
