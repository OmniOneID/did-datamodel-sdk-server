/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.enums.profile;

import java.util.EnumSet;

public enum SymmetricPaddingType {
	NOPAD("NOPAD"), PKCS5("PKCS5");

	private String rawValue;

	SymmetricPaddingType(String rawValue) {
		this.rawValue = rawValue;
	}

	public String getRawValue() {
		return rawValue;
	}

	public static SymmetricPaddingType fromString(String text) {
		for (SymmetricPaddingType b : SymmetricPaddingType.values()) {
			if (b.rawValue.equalsIgnoreCase(text)) {
				return b;
			}
		}
		return null;
	}

	public static EnumSet<SymmetricPaddingType> all() {
		return EnumSet.allOf(SymmetricPaddingType.class);
	}

}
