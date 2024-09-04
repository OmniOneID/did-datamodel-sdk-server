/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.enums.did;

import java.util.EnumSet;

public enum AuthType {
	Free(1 << 0),	// 1 - No authentication
	PIN(1 << 1),	// 2 - Password authentication
	BIO(1 << 2);	// 4 - Biometric authentication

	private int rawValue;

	AuthType(int rawValue) {
		this.rawValue = rawValue;
	}

	public int getRawValue() {
		return rawValue;
	}

	public static void main(String[] args) {
		EnumSet<AuthType> authTypes = EnumSet.of(AuthType.Free);

		for (AuthType authType : authTypes) {
			System.out.println(authType + ": " + authType.getRawValue());
		}

	}
}
