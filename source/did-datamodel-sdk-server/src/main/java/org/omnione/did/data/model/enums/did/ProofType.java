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
