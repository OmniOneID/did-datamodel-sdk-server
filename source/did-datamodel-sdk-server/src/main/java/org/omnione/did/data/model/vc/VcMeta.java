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

package org.omnione.did.data.model.vc;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import org.omnione.did.data.model.DataObject;
import org.omnione.did.data.model.did.constants.DateFormatConstants;
import org.omnione.did.data.model.provider.Provider;
import org.omnione.did.data.model.util.json.GsonWrapper;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 
 * {@link VerifiableCredential} 
 */

@Getter
@Setter
public class VcMeta extends DataObject {

	/**
	 * VC id - UUID
	 */
	@SerializedName("id")
	@Expose @NotEmpty
	private String id;

	/**
	 * Issuer Infos
	 */
	@SerializedName("issuer")
	@Expose @NotNull @Valid
	private Provider issuer;

	/**
	 * Subject did
	 */
	@SerializedName("subject")
	@Expose @NotEmpty
	private String subject;

	/**
	 * credential Schema
	 */ 
	@SerializedName("credentialSchema") 
	@Expose @NotNull @Valid
	private CredentialSchema credentialSchema;


	/**
	 * VCStatus enum value
	 */
	@SerializedName("status")
	@Expose @NotEmpty
	private String status;

	/**
	 * Issued time(UTC)
	 */
	@SerializedName("issuanceDate")
	@Expose @NotEmpty
	@Pattern(regexp = DateFormatConstants.DATA_FORMAT, message = DateFormatConstants.DATA_FORMAT_MESSAGE)
	private String issuanceDate;

	/**
	 * Validity period start time(UTC)
	 */
	@SerializedName("validFrom")
	@Expose @NotEmpty
	@Pattern(regexp = DateFormatConstants.DATA_FORMAT, message = DateFormatConstants.DATA_FORMAT_MESSAGE)
	private String validFrom;

	/**
	 * Validity period end time(UTC)
	 */
	@SerializedName("validUntil")
	@Expose	@NotEmpty
	@Pattern(regexp = DateFormatConstants.DATA_FORMAT, message = DateFormatConstants.DATA_FORMAT_MESSAGE)
	private String validUntil;

	/**
	 * VC format version
	 */
	@SerializedName("formatVersion")
	@Expose	@NotEmpty
	private String formatVersion;

	/**
	 * VC File language
	 */
	@SerializedName("language")
	@Expose	@NotEmpty
	private String language;

	@Override
	public void fromJson(String val) {
		GsonWrapper gson = new GsonWrapper();
		VcMeta data = gson.fromJson(val, VcMeta.class);

		id = data.id;
		issuer = data.issuer;
		subject = data.subject;
		credentialSchema = data.credentialSchema;
		status = data.status;
		issuanceDate = data.issuanceDate;
		validFrom = data.validFrom;
		validUntil = data.validUntil;
		formatVersion = data.formatVersion;
		language = data.language;
	}

}
