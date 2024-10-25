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

package org.omnione.did.data.model.enums.vc;

import java.util.EnumSet;

public enum Location {
	// The claim original data is in the internal value of the VC.
	INLINE("inline"),
	// Claim original data is in external link url
	REMOTE("remote"), 
	// The original claim data is in a separate attached file.
	ATTACH("attach");

	private String rawValue;

	Location(String rawValue) {
		this.rawValue = rawValue;
	}


	public String getRawValue() {
		return rawValue;
	}
	
	public static Location fromString(String text) {
		for (Location b : Location.values()) {
			if (b.rawValue.equalsIgnoreCase(text)) {
				return b;
			}
		}
		return null;
	}

	public static EnumSet<Location> all() {
		return EnumSet.allOf(Location.class);
	}

}
