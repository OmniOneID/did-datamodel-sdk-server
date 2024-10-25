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

package org.omnione.did.data.model.profile.verify;

import org.omnione.did.data.model.DataObject;
import org.omnione.did.data.model.profile.Filter;
import org.omnione.did.data.model.provider.ProviderDetail;
import org.omnione.did.data.model.util.json.GsonWrapper;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
/**
 * @author 
 */

@Getter
@Setter
public class InnerVerifyProfile extends DataObject {

	/**
	 * verifier Infos
	 */
	@SerializedName("verifier")
	@Expose @NotNull
	@Valid
	private ProviderDetail verifier;

	/**
	 * Filters to select VCs to submit
	 */
	@SerializedName("filter")
	@Expose
	private Filter filter;
	
	/**
	 * How to Submit a VP
	 */
	@SerializedName("process")
	@Expose
	private VerifyProcess process;

	@Override
	public void fromJson(String val) {
		GsonWrapper gson = new GsonWrapper();
		InnerVerifyProfile data = gson.fromJson(val, InnerVerifyProfile.class);

		verifier = data.verifier;
		filter = data.filter;
	}

}
