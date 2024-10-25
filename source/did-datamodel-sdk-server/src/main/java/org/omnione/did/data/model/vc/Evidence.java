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

import jakarta.validation.constraints.NotEmpty;

import org.omnione.did.data.model.DataObject;
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
public class Evidence extends DataObject {

	/**
	 * URL
	 */
	@SerializedName("id")
	@Expose		
	private String id;

	/**
	 * EvidenceType enum value
	 */
	@SerializedName("type")
	@Expose @NotEmpty
	private String type;

	/**
	 * Evidence verifier did
	 */
	@SerializedName("verifier")
	@Expose @NotEmpty
	private String verifier;

	@Override
	public void fromJson(String val) {
		GsonWrapper gson = new GsonWrapper();
		Evidence data = gson.fromJson(val, Evidence.class);
		
		id = data.id;
		type = data.type;
		verifier = data.verifier;
	

	}

}
