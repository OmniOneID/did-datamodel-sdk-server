/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.profile.issue;

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
public class IssueProcess extends Process {

	/**
	 * issuer Nonce (multibase) byte_length(16)
	 */
	@SerializedName("issuerNonce")
	@Expose
	@NotEmpty
	private String issuerNonce;

	@Override
	public void fromJson(String val) {
		super.fromJson(val);

		GsonWrapper gson = new GsonWrapper();
		IssueProcess data = gson.fromJson(val, IssueProcess.class);

		issuerNonce = data.issuerNonce;
	}
}
