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
