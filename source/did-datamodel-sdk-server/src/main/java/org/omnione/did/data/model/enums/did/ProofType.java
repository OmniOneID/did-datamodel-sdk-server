/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.enums.did;

import java.util.EnumSet;

public enum ProofType {
	
	RSA_SIGNATURE_2018("RsaSignature2018"),
	SECP256K1_SIGNATURE_2018("Secp256k1Signature2018"),
	SECP256R1_SIGNATURE_2018("Secp256r1Signature2018");


	private String rawValue;

	ProofType(String rawValue) {
		this.rawValue = rawValue;
	}

	public String getRawValue() {
		return rawValue;
	}

	public static ProofType fromString(String rawlavue) {
		for (ProofType b : ProofType.values()) {
			if (b.rawValue.equalsIgnoreCase(rawlavue)) {
				return b;
			}
		}
		return null;
	}

	public static EnumSet<ProofType> all() {
		return EnumSet.allOf(ProofType.class);
	}

}
