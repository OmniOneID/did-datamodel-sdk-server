/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.enums.profile;

import java.util.EnumSet;

public enum OfferType {
	ISSUE_OFFER("IssueOffer"),// Issuer offer information
	VERIFY_OFFER("VerifyOffer");// verify offer information

	private String rawValue;

	OfferType(String rawValue) {
		this.rawValue = rawValue;
	}


	public String getRawValue() {
		return rawValue;
	}
	
	public static OfferType fromString(String text) {
		for (OfferType b : OfferType.values()) {
			if (b.rawValue.equalsIgnoreCase(text)) {
				return b;
			}
		}
		return null;
	}

	public static EnumSet<OfferType> all() {
		return EnumSet.allOf(OfferType.class);
	}

}
