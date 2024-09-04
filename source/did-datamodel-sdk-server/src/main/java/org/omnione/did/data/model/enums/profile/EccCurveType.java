/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.enums.profile;

import java.util.EnumSet;

public enum EccCurveType {
	SECP256K1("Secp256k1"),
	SECP256R1("Secp256r1");

	private String rawValue;

	EccCurveType(String rawValue) {
		this.rawValue = rawValue;
	}


	public String getRawValue() {
		return rawValue;
	}
	
	public static EccCurveType fromString(String text) {
		for (EccCurveType b : EccCurveType.values()) {
			if (b.rawValue.equalsIgnoreCase(text)) {
				return b;
			}
		}
		return null;
	}

	public static EnumSet<EccCurveType> all() {
		return EnumSet.allOf(EccCurveType.class);
	}

}
