/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.enums.vc;

import java.util.EnumSet;

public enum CredentialSchemaType  {
	OSD_SCHEMA_CREDENTIAL("OsdSchemaCredential");

	private String rawValue;

	CredentialSchemaType(String rawValue) {
		this.rawValue = rawValue;
	}


	public String getRawValue() {
		return rawValue;
	}
	
	public static CredentialSchemaType fromString(String text) {
		for (CredentialSchemaType b : CredentialSchemaType.values()) {
			if (b.rawValue.equalsIgnoreCase(text)) {
				return b;
			}
		}
		return null;
	}

	public static EnumSet<CredentialSchemaType> all() {
		return EnumSet.allOf(CredentialSchemaType.class);
	}
}
