/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.enums.vp;

import java.util.EnumSet;

public enum PresentMode {
	DIRECT("Direct"),
	INDIRECT("Indirect"),
	PROXY("Proxy"); // not Supported

	private String rawValue;

	PresentMode(String rawValue) {
		this.rawValue = rawValue;
	}


	public String getRawValue() {
		return rawValue;
	}
	
	public static PresentMode fromString(String text) {
		for (PresentMode b : PresentMode.values()) {
			if (b.rawValue.equalsIgnoreCase(text)) {
				return b;
			}
		}
		return null;
	}

	public static EnumSet<PresentMode> all() {
		return EnumSet.allOf(PresentMode.class);
	}

}
