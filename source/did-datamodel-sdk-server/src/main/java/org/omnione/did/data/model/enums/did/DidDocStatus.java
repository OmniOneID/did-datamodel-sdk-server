/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.enums.did;

public enum DidDocStatus {
	ACTIVATED("ACTIVATED"),
	DEACTIVATED("DEACTIVATED"),
	REVOKED("REVOKED"),
	TERMINATED("TERMINATED");

	private String rawValue;

	DidDocStatus(String rawValue) {
		this.rawValue = rawValue;
	}

	public String getRawValue() {
		return rawValue;
	}

}
