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
