/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.enums.did;

import java.util.EnumSet;

public enum DidServiceType {
	LINKED_DOMAINS("LinkedDomains"), //"site URL"
	CREDENTIAL_REGISTRY("CredentialRegistry");// URL to query verifiable credentials

	private String rawValue;

	DidServiceType(String rawValue) {
		this.rawValue = rawValue;
	}

	public String getRawValue() {
		return rawValue;
	}

	public static DidServiceType fromString(String text) {
		for (DidServiceType b : DidServiceType.values()) {
			if (b.rawValue.equalsIgnoreCase(text)) {
				return b;
			}
		}
		return null;
	}

	public static EnumSet<DidServiceType> all() {
		return EnumSet.allOf(DidServiceType.class);
	}

}
