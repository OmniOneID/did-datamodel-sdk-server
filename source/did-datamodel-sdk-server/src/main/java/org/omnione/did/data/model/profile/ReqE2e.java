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

package org.omnione.did.data.model.profile;

import jakarta.validation.constraints.NotEmpty;

import org.omnione.did.data.model.DataObject;
import org.omnione.did.data.model.did.Proof;
import org.omnione.did.data.model.util.json.GsonWrapper;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;
/**
 * @author 
 * E2E request data
 */

@Getter
@Setter
public class ReqE2e extends DataObject {

	/**
	 * Nonce for E2E symmetric key generation
	 * byte_length(16)
	 */
	@SerializedName("nonce")
	@Expose @NotEmpty 
	private String nonce;

	/**
	 * EccCurveType enum value
	 */
	@SerializedName("curve")
	@Expose @NotEmpty 
	private String curve;

	/**
	 * Server public key for E2E encryption
	 * Multibase String
	 */
	@SerializedName("publicKey")
	@Expose @NotEmpty 
	private String publicKey;

	/**
	 * SymmetricCipherType enum value
	 */
	@SerializedName("cipher")
	@Expose @NotEmpty 
	private String cipher;

	/**
	 * SymmetricPaddingType enum value
	 */
	@SerializedName("padding")
	@Expose @NotEmpty 
	private String padding;
	
	/**
	 * key agreement proof"
	 */
	@SerializedName("proof")
	@Expose
	private Proof proof;

	@Override
	public void fromJson(String val) {
		GsonWrapper gson = new GsonWrapper();
		ReqE2e data = gson.fromJson(val, ReqE2e.class);

		nonce = data.nonce;
		curve = data.curve;
		publicKey = data.publicKey;
		cipher = data.cipher;
		padding = data.padding;

	}

}
