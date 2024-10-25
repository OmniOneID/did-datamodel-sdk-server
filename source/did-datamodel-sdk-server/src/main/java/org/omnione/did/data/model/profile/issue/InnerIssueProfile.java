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

package org.omnione.did.data.model.profile.issue;

import org.omnione.did.data.model.DataObject;
import org.omnione.did.data.model.provider.ProviderDetail;
import org.omnione.did.data.model.util.json.GsonWrapper;
import org.omnione.did.data.model.vc.CredentialSchema;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
/**
 * @author 
 * Profile Contents
 */

@Getter
@Setter
public class InnerIssueProfile extends DataObject {

	/**
	 * Issuer Infos
	 */
	@SerializedName("issuer")
	@Expose @NotNull
	private ProviderDetail issuer;

	/**
	 * VC Schema Infos
	 */
	@SerializedName("credentialSchema")
	@Expose  @NotNull
	@Valid
	private CredentialSchema credentialSchema;

	/**
	 * Issuance Process
	 */
	@SerializedName("process")
	@Expose @NotNull
	@Valid
	private IssueProcess process;

	@Override
	public void fromJson(String val) {
		GsonWrapper gson = new GsonWrapper();
		InnerIssueProfile data = gson.fromJson(val, InnerIssueProfile.class);

		issuer = data.issuer;
		credentialSchema = data.credentialSchema;
		process = data.process;

	}

}
