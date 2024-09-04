/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.enums.vc;

import java.util.EnumSet;

public enum Language {
	KO("ko"),
	EN("en"),
	FR("fr"),
	JP("jp");
	
	private String rawValue;

	Language(String rawValue) {
		this.rawValue = rawValue;
	}


	public String getRawValue() {
		return rawValue;
	}
	
	public static Language fromString(String text) {
		for (Language b : Language.values()) {
			if (b.rawValue.equalsIgnoreCase(text)) {
				return b;
			}
		}
		return null;
	}

	public static EnumSet<Language> all() {
		return EnumSet.allOf(Language.class);
	}

}
