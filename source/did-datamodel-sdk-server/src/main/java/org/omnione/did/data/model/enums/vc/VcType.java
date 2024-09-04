/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.enums.vc;

import java.util.EnumSet;

public enum VcType {
	VERIFIABLE_CREDENTIAL("VerifiableCredential"),// VC
	CERTIFICATE_VC("CertificateVC");// VC for membership certificate issued by TAS"


	private String rawValue;

	VcType(String rawValue) {
		this.rawValue = rawValue;
	}


	public String getRawValue() {
		return rawValue;
	}
	
	public static VcType fromString(String text) {
		for (VcType b : VcType.values()) {
			if (b.rawValue.equalsIgnoreCase(text)) {
				return b;
			}
		}
		return null;
	}

	public static EnumSet<VcType> all() {
		return EnumSet.allOf(VcType.class);
	}

}
