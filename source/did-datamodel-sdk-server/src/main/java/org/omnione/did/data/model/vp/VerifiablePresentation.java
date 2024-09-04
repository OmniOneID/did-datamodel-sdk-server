/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.vp;

import java.util.List;

import org.omnione.did.data.model.DataObject;
import org.omnione.did.data.model.did.constants.DateFormatConstants;
import org.omnione.did.data.model.util.json.GsonWrapper;
import org.omnione.did.data.model.vc.VerifiableCredential;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

/**
 * @author 
 */

@Getter
@Setter
public class VerifiablePresentation extends DataObject {

	/**
	 * JSON-LD context ["https://www.w3.org/ns/credentials/v2"]
	 */
	@SerializedName("@context")
	@Expose @NotEmpty
	private List<String> context;

	/**
	 *  vp id - uuid
	 */
	@SerializedName("id")
	@Expose @NotEmpty
	private String id;

	/**
	 *  VpType enum value
	 */
	@SerializedName("type")
	@Expose @NotEmpty
	private List<String> type;

	/**
	 *   holder did
	 */
	@SerializedName("holder")
	@Expose @NotEmpty
	private String holder;

	/**
	 *  VP Validity period start time(UTC)
	 */
	@SerializedName("validFrom")
	@Expose @NotEmpty
	@Pattern(regexp = DateFormatConstants.DATA_FORMAT, message = DateFormatConstants.DATA_FORMAT_MESSAGE)
	private String validFrom;

	/**
	 *  VP Validity period end time(UTC)
	 */
	@SerializedName("validUntil")
	@Expose @NotEmpty
	@Pattern(regexp = DateFormatConstants.DATA_FORMAT, message = DateFormatConstants.DATA_FORMAT_MESSAGE)
	private String validUntil;

	/**
	 *  Multi-encoded value of bytes with a length of 16
	 */
	@SerializedName("verifierNonce")
	@Expose @NotEmpty
	private String verifierNonce;

	/**
	 *  verifiableCredential(VC)
	 */
	@SerializedName("verifiableCredential")
	@Expose @NotNull
	private List<VerifiableCredential> verifiableCredential;

	/**
	 *  Holder signature for VP
	 */
	@SerializedName("proof")
	@Expose @Valid
	private VpProof proof;
	
	@SerializedName("proofs")
	@Expose
	private List<@Valid VpProof> proofs;

	@Override
	public void fromJson(String val) {
		GsonWrapper gson = new GsonWrapper();
		VerifiablePresentation data = gson.fromJson(val, VerifiablePresentation.class);

		context = data.context;
		id = data.id;
		type = data.type;
		holder = data.holder;
		validFrom = data.validFrom;
		validUntil = data.validUntil;
		verifierNonce = data.verifierNonce;
		verifiableCredential = data.verifiableCredential;
		proof = data.proof;
		proofs = data.proofs;

	}

}
