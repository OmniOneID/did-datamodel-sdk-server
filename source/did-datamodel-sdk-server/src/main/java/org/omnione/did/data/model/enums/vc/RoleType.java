/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.enums.vc;

import java.util.EnumSet;

public enum RoleType {
	TAS("Tas"),
	WALLET("Wallet"),
	ISSUER("Issuer"),
	VERIFIER("Verifier"),
	WALLET_PROVIDER("WalletProvider"),
	APP_PROVIDER("AppProvider"),
	LIST_PROVIDER("ListProvider"),
	OP_PROVIDER("OpProvider"),
	KYC_PROVIDER("KycProvider"),
	NOTIFICATION_PROVIDER("NotificationProvider"),
	LOG_PROVIDER("LogProvider"),
	PORTAL_PROVIDER("PortalProvider"),
	DELEGATION_PROVIDER("DelegationProvider"),
	STORAGE_PROVIDER("StorageProvider"),
	BACKUP_PROVIDER("BackupProvider"),
	ETC("Etc");

	private String rawValue;

	RoleType(String rawValue) {
		this.rawValue = rawValue;
	}


	public String getRawValue() {
		return rawValue;
	}
	
	public static RoleType fromString(String text) {
		for (RoleType b : RoleType.values()) {
			if (b.rawValue.equalsIgnoreCase(text)) {
				return b;
			}
		}
		return null;
	}

	public static EnumSet<RoleType> all() {
		return EnumSet.allOf(RoleType.class);
	}

}
