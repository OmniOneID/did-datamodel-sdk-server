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

package org.omnione.did.data.model.enums.profile;

import java.util.EnumSet;

public enum SymmetricPaddingType {
	NOPAD("NOPAD"), PKCS5("PKCS5");

	private String rawValue;

	SymmetricPaddingType(String rawValue) {
		this.rawValue = rawValue;
	}

	public String getRawValue() {
		return rawValue;
	}

	public static SymmetricPaddingType fromString(String text) {
		for (SymmetricPaddingType b : SymmetricPaddingType.values()) {
			if (b.rawValue.equalsIgnoreCase(text)) {
				return b;
			}
		}
		return null;
	}

	public static EnumSet<SymmetricPaddingType> all() {
		return EnumSet.allOf(SymmetricPaddingType.class);
	}

}
