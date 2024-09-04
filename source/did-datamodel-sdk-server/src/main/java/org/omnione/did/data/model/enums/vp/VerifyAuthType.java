/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.enums.vp;

public enum VerifyAuthType {

	NO_RESTRICTION(0), 
	NO_AUTH(1 << 0), 
	PIN(1 << 1), 
	BIO(1 << 2);

	private final int rawValue;

	VerifyAuthType(int rawValue) {
		this.rawValue = rawValue;

	}

	public int getRawValue() {
		return rawValue;
	}

	public static VerifyAuthType fromCode(int rawValue) {
		for (VerifyAuthType type : VerifyAuthType.values()) {
			if (type.rawValue == rawValue) {
				return type;
			}
		}
		throw new IllegalArgumentException("Unknown code: " + rawValue);
	}

}
