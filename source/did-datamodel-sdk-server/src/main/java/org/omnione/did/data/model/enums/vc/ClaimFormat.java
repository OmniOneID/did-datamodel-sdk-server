/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.enums.vc;

import java.util.EnumSet;

public enum ClaimFormat {
	PLAIN("plain"),
	HTML("html"), 
	XML("xml"),
	CSV("csv"), 
	PNG("png"), 
	JPG("jpg"), 
	GIF("gif"), 
	TXT("txt"), 
	PDF("pdf"), 
	WORD("word");
	
	private String rawValue;

	ClaimFormat(String rawValue) {
		this.rawValue = rawValue;
	}


	public String getRawValue() {
		return rawValue;
	}
	
	public static ClaimFormat fromString(String text) {
		for (ClaimFormat b : ClaimFormat.values()) {
			if (b.rawValue.equalsIgnoreCase(text)) {
				return b;
			}
		}
		return null;
	}

	public static EnumSet<ClaimFormat> all() {
		return EnumSet.allOf(ClaimFormat.class);
	}

}
