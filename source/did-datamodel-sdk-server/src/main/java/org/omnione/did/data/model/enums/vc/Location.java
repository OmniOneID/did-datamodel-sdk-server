/* 
 * Copyright 2024 Raonsecure
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
