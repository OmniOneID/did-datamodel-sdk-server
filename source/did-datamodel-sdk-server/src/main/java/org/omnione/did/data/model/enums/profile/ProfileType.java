/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.enums.profile;

import java.util.EnumSet;

public enum ProfileType {
	ISSUE_PROFILE("IssueProfile"), // Issue request information
	VERIFY_PROFILE("VerifyProfile"); // verify request information

	private String rawValue;

	ProfileType(String rawValue) {
		this.rawValue = rawValue;
	}


	public String getRawValue() {
		return rawValue;
	}
	
	public static ProfileType fromString(String text) {
		for (ProfileType b : ProfileType.values()) {
			if (b.rawValue.equalsIgnoreCase(text)) {
				return b;
			}
		}
		return null;
	}

	public static EnumSet<ProfileType> all() {
		return EnumSet.allOf(ProfileType.class);
	}

}
