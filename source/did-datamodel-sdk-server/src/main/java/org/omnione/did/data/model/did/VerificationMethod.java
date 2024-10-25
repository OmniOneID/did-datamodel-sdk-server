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

package org.omnione.did.data.model.did;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

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
public class VerificationMethod extends DataObject{

	
	/**
	 * key id(name)
	 */
	@SerializedName("id")
    @Expose @NotEmpty
    private String id;
	
	/**
	 * enum DIDKeyType value
	 */
	@SerializedName("type")
    @Expose @NotEmpty
    private String type;
	
	/**
	 * key controller's did
	 */
	@SerializedName("controller")
    @Expose @NotEmpty
    private String controller;
	
	
	/**
	 * public key value
	 */
	@SerializedName("publicKeyMultibase")
    @Expose @NotEmpty
    private String publicKeyMultibase;
	
	
	/**
	 * enum AuthType value
	 * non-standard
	 */
	@SerializedName("authType")
    @Expose @NotNull
    private Integer authType;


	@Override
	public void fromJson(String val) {
		GsonWrapper gson = new GsonWrapper();
		VerificationMethod data = gson.fromJson(val, VerificationMethod.class);
		
		id = data.id;
		type = data.type;
		controller = data.controller;
		publicKeyMultibase = data.publicKeyMultibase;
		authType = data.authType;
		
	}
}
