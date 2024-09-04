/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.enums.vc;

import java.util.EnumSet;

public enum ClaimType {
	TEXT("text"),
	IMAGE("image"), 
	DOCUMENT("document");

	private String rawValue;

	ClaimType(String rawValue) {
		this.rawValue = rawValue;
	}


	public String getRawValue() {
		return rawValue;
	}
	
	public static ClaimType fromString(String text) {
		for (ClaimType b : ClaimType.values()) {
			if (b.rawValue.equalsIgnoreCase(text)) {
				return b;
			}
		}
		return null;
	}

	public static EnumSet<ClaimType> all() {
		return EnumSet.allOf(ClaimType.class);
	}

}
