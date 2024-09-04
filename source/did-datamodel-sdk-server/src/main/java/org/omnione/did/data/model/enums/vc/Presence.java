/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.enums.vc;

import java.util.EnumSet;

public enum Presence {
	PHYSICAL("Physical"), // Physical evidence, such as printed documents
	DIGITAL("Digital");// Digital evidence that can be read and verified electronically

	private String rawValue;

	Presence(String rawValue) {
		this.rawValue = rawValue;
	}


	public String getRawValue() {
		return rawValue;
	}
	
	public static Presence fromString(String text) {
		for (Presence b : Presence.values()) {
			if (b.rawValue.equalsIgnoreCase(text)) {
				return b;
			}
		}
		return null;
	}

	public static EnumSet<Presence> all() {
		return EnumSet.allOf(Presence.class);
	}

}
