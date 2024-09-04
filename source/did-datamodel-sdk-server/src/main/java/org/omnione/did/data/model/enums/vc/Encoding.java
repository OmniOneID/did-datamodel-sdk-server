/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.enums.vc;

import java.util.EnumSet;

public enum Encoding {
	UTF_8("UTF-8");

	
	private String rawValue;

	Encoding(String rawValue) {
		this.rawValue = rawValue;
	}


	public String getRawValue() {
		return rawValue;
	}
	
	public static Encoding fromString(String text) {
		for (Encoding b : Encoding.values()) {
			if (b.rawValue.equalsIgnoreCase(text)) {
				return b;
			}
		}
		return null;
	}

	public static EnumSet<Encoding> all() {
		return EnumSet.allOf(Encoding.class);
	}

}
