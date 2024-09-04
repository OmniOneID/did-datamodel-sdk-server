/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.enums.did;

import java.util.EnumSet;

public enum ProofPurpose {
	
	// Data integrity validation
	ASSERTION_METHOD("assertionMethod"), 
	// DID Subject authentication
	AUTHENTICATION("authentication"),
	// Key exchange for encrypted communication
	KEY_AGREEMENT("keyAgreement"),
	// Perform encryption functions (Updating DID document , etc.)
	CAPABILITY_INVOCATION("capabilityInvocation"),
	// Delegate encryption functions to a third party
	CAPABILITY_DELEGATION("capabilityDelegation");

	private String rawValue;

	ProofPurpose(String rawValue) {
		this.rawValue = rawValue;
	}

	public String getRawValue() {
		return rawValue;
	}

	public static ProofPurpose fromString(String rawlavue) {
		for (ProofPurpose b : ProofPurpose.values()) {
			if (b.rawValue.equalsIgnoreCase(rawlavue)) {
				return b;
			}
		}
		return null;
	}

	public static EnumSet<ProofPurpose> all() {
		return EnumSet.allOf(ProofPurpose.class);
	}


}
