/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.vc;

import jakarta.validation.constraints.NotEmpty;

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
public class DocumentVerificationEvidence extends Evidence {

	/**
	 * Name of required evidentiary documents
	 */
	@SerializedName("evidenceDocument")
	@Expose @NotEmpty
	private String evidenceDocument;

	/**
	 * How to identify the subject
	 * @see Presence
	 */
	@SerializedName("subjectPresence")
	@Expose @NotEmpty
	private String subjectPresence;

	/**
	 * How to submit required documents
	 * @see Presence
	 */
	@SerializedName("documentPresence")
	@Expose @NotEmpty
	private String documentPresence;

	/**
	 * The license number of the document
	 * @see Presence
	 */
	@SerializedName("licenseNumber")
	@Expose
	private String licenseNumber;

	@Override
	public void fromJson(String val) {
		super.fromJson(val);
		
		GsonWrapper gson = new GsonWrapper();
		DocumentVerificationEvidence data = gson.fromJson(val, DocumentVerificationEvidence.class);
		
		evidenceDocument = data.evidenceDocument;
		subjectPresence = data.subjectPresence;
		documentPresence = data.documentPresence;
		licenseNumber = data.licenseNumber;
	}

}
