/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.enums.vc;

import java.util.EnumSet;

public enum VcStatus {
	ACTIVE("ACTIVE"),
	INACTIVE("INACTIVE"),
	REVOKED("REVOKED");


	private String rawValue;

	VcStatus(String rawValue) {
		this.rawValue = rawValue;
	}


	public String getRawValue() {
		return rawValue;
	}
	
	public static VcStatus fromString(String text) {
		for (VcStatus b : VcStatus.values()) {
			if (b.rawValue.equalsIgnoreCase(text)) {
				return b;
			}
		}
		return null;
	}

	public static EnumSet<VcStatus> all() {
		return EnumSet.allOf(VcStatus.class);
	}

}
