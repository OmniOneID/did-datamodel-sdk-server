/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.enums.vc;

import java.util.EnumSet;

public enum EvidenceType {
	DOCUMENT_VERIFICATION("DocumentVerification");


	private String rawValue;

	EvidenceType(String rawValue) {
		this.rawValue = rawValue;
	}


	public String getRawValue() {
		return rawValue;
	}
	
	public static EvidenceType fromString(String text) {
		for (EvidenceType b : EvidenceType.values()) {
			if (b.rawValue.equalsIgnoreCase(text)) {
				return b;
			}
		}
		return null;
	}

	public static EnumSet<EvidenceType> all() {
		return EnumSet.allOf(EvidenceType.class);
	}

}
