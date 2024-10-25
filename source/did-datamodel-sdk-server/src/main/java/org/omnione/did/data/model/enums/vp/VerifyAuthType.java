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

package org.omnione.did.data.model.enums.vp;

public enum VerifyAuthType {

	NO_RESTRICTION(0), 
	NO_AUTH(1 << 0), 
	PIN(1 << 1), 
	BIO(1 << 2);

	private final int rawValue;

	VerifyAuthType(int rawValue) {
		this.rawValue = rawValue;

	}

	public int getRawValue() {
		return rawValue;
	}

	public static VerifyAuthType fromCode(int rawValue) {
		for (VerifyAuthType type : VerifyAuthType.values()) {
			if (type.rawValue == rawValue) {
				return type;
			}
		}
		throw new IllegalArgumentException("Unknown code: " + rawValue);
	}

}
