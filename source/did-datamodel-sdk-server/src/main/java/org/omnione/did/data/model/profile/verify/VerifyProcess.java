/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.profile.verify;

import jakarta.validation.constraints.NotEmpty;

import org.omnione.did.data.model.profile.Process;
import org.omnione.did.data.model.util.json.GsonWrapper;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;
/**
 * @author 
 */

@Getter
@Setter
public class VerifyProcess extends Process {

	/**	 
	 * verifier Nonce
	 * (multibase) byte_length(16)
	 */
	@SerializedName("verifierNonce")
	@Expose @NotEmpty
	private String verifierNonce;

	/**	 
	 * Authentication method for submission
	 * VerifyAuthType enums value
	 */
	@SerializedName("authType")
	@Expose
	private int authType;

	public void fromJson(String val) {
		super.fromJson(val);

		GsonWrapper gson = new GsonWrapper();
		VerifyProcess data = gson.fromJson(val, VerifyProcess.class);

		verifierNonce = data.verifierNonce;
		authType = data.authType;

	}

}
