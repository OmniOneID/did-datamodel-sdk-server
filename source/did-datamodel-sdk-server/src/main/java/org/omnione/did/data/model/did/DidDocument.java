/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.did;

import java.util.List;

import org.omnione.did.data.model.DataObject;
import org.omnione.did.data.model.did.constants.DateFormatConstants;
import org.omnione.did.data.model.util.json.GsonWrapper;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 * @author 
 * The format complies with W3C's [DID-V1.0].
 */
@Getter
@Setter
public class DidDocument extends DataObject {
	/**
	 * JSON-LD context
	 */
	@SerializedName("@context")
	@Expose
	@NotEmpty
	private List<String> context;

	/**
	 * DID owner's did format : did:method-name:method-specific-id
	 */
	@SerializedName("id")
	@Expose
	@NotEmpty
	private String id;

	/**
	 * DID controller's did (TAS did)
	 */
	@SerializedName("controller")
	@Expose
	@NotEmpty
	private String controller;

	/**
	 * created time(UTC)
	 */
	@SerializedName("created")
	@Expose
	@NotEmpty
	@Pattern(regexp = DateFormatConstants.DATA_FORMAT, message = DateFormatConstants.DATA_FORMAT_MESSAGE)
	private String created;

	/**
	 * last updated time(UTC)
	 */
	@SerializedName("updated")
	@Expose
	@NotEmpty
	@Pattern(regexp = DateFormatConstants.DATA_FORMAT, message = DateFormatConstants.DATA_FORMAT_MESSAGE)
	private String updated;

	/**
	 * DID version id
	 */
	@SerializedName("versionId")
	@Expose
	@NotEmpty(message = "The string must not be empty")
	@Pattern(regexp = DateFormatConstants.VERSION_ID, message = DateFormatConstants.VERSION_ID_MESSAGE)
	private String versionId;

	/**
	 * true: deactivated false: activated
	 */
	@SerializedName("deactivated")
	@Expose @NotNull
	private Boolean deactivated = false;

	/**
	 * list of DID key with public key value
	 */
	@SerializedName("verificationMethod")
	@Expose
	@Size(min = 1, message = "The array must have at least one element")
	private List<@Valid VerificationMethod> verificationMethod;

	/**
	 * list of Assertion key name
	 * Must be the key name declared in verificationMethod
	 */
	@SerializedName("assertionMethod")
	@Expose
	private List<String> assertionMethod;

	/**
	 * list of Authentication key name
	 * Must be the key name declared in verificationMethod
	 */
	@SerializedName("authentication")
	@Expose
	private List<String> authentication;

	/**
	 * list of Key Agreement key name
	 * Must be the key name declared in verificationMethod
	 */
	@SerializedName("keyAgreement")
	@Expose
	private List<String> keyAgreement;

	/**
	 * list of Capability Invocation key name
	 * Must be the key name declared in verificationMethod
	 */
	@SerializedName("capabilityInvocation")
	@Expose
	private List<String> capabilityInvocation;

	/**
	 * list of Capability Delegation key name
	 * Must be the key name declared in verificationMethod
	 */
	@SerializedName("capabilityDelegation")
	@Expose
	private List<String> capabilityDelegation;

	/**
	 * list of service
	 */
	@SerializedName("service")
	@Expose
	private List<@Valid Service> service;
	
	/**
	 * 
	 */
	@SerializedName("proof")
	@Expose @Valid
	private Proof proof;

	/**
	 * DID Document with the owner proofs Signing information for all keys other
	 * than the key Agreement
	 */
	@SerializedName("proofs")
	@Expose
	private List<@Valid Proof> proofs;
	
	
	public DidDocument() {	
	}
    
	public DidDocument(String val) {
		fromJson(val);
	}

	@Override
	public void fromJson(String val) {
		GsonWrapper gson = new GsonWrapper();
		DidDocument data = gson.fromJson(val, DidDocument.class);

		context = data.context;
		id = data.id;
		controller = data.controller;
		created = data.created;
		updated = data.updated;
		versionId = data.versionId;
		deactivated = data.deactivated;
		verificationMethod = data.verificationMethod;
		assertionMethod = data.assertionMethod;
		authentication = data.authentication;
		keyAgreement = data.keyAgreement;
		capabilityInvocation = data.capabilityInvocation;
		capabilityDelegation = data.capabilityDelegation;
		service = data.service;
		proof = data.proof;
		proofs = data.proofs;

	}

}
