/*
 * Copyright 2024 OmniOne.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
