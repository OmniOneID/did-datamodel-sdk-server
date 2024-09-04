/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.did;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

import org.omnione.did.data.model.DataObject;
import org.omnione.did.data.model.did.constants.DateFormatConstants;
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
public class Proof extends DataObject {

	/**
	 *  ProofType enum value
	 */
	@SerializedName("type")
	@Expose @NotEmpty
	private String type;

	/**
	 * created time
	 */
	@SerializedName("created")
	@Expose @NotEmpty
	@Pattern(regexp = DateFormatConstants.DATA_FORMAT, message = DateFormatConstants.DATA_FORMAT_MESSAGE)
	private String created;


	/**
	 * didKeyUrl
	 * Composed of did, versionId, and didKeyId
	 */
	// TODO Additional modification of the patten string part is required.
	@SerializedName("verificationMethod")
	@Expose @NotEmpty
	@Pattern(regexp = DateFormatConstants.DID_KEY_URL, message = DateFormatConstants.DID_KEY_URL_MESSAGE)
	private String verificationMethod;

	/**
	 * enum ProofPurpose value
	 */
	@SerializedName("proofPurpose")
	@Expose @NotEmpty
	private String proofPurpose;

	
	/**
	 * Multi-base encoded signature value
	 */
	@SerializedName("proofValue")
	@Expose 
	private String proofValue;
	
	
	@Override
	public void fromJson(String val) {
		GsonWrapper gson = new GsonWrapper();
		Proof data = gson.fromJson(val, Proof.class);

		type = data.type;
		created = data.created;
		verificationMethod = data.verificationMethod;
		proofPurpose = data.proofPurpose;
		proofValue = data.proofValue;

	}
	
}
