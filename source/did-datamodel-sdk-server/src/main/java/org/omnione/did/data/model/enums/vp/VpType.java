/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.enums.vp;

import java.util.EnumSet;

public enum VpType {
	VP("VerifiablePresentation");

	private String rawValue;

	VpType(String rawValue) {
		this.rawValue = rawValue;
	}


	public String getRawValue() {
		return rawValue;
	}
	
	public static VpType fromString(String text) {
		for (VpType b : VpType.values()) {
			if (b.rawValue.equalsIgnoreCase(text)) {
				return b;
			}
		}
		return null;
	}

	public static EnumSet<VpType> all() {
		return EnumSet.allOf(VpType.class);
	}

}
