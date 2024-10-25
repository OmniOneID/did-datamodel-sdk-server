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

package org.omnione.did.data.model.schema;

import jakarta.validation.Valid;
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
public class VcSchema extends DataObject{
	
	/**
	 * VC schema URL
	 */
	@SerializedName("@id")
	@Expose @NotEmpty
	private String id;
	
	/**
	 *  VC Schema format URL(osd url)
	 */
	@SerializedName("@schema")
	@Expose @NotEmpty
	private String schema;
	
	/**
	 * schema name
	 */
	@SerializedName("title")
	@Expose @NotEmpty
	private String title;
	
	/**
	 * description
	 */
	@SerializedName("description")
	@Expose @NotEmpty
	private String description;
	
	/**
	 * metadata
	 */
	@SerializedName("metadata")
	@Expose @NotNull
	@Valid
	private MetaData metadata;
	
	/**
	 * metadata
	 */
	@SerializedName("credentialSubject")
	@Expose @NotNull
	@Valid
	private SchemaCredentialSubject credentialSubject;
	
	@Override
	public void fromJson(String val) {
		GsonWrapper gson = new GsonWrapper();
		VcSchema data = gson.fromJson(val, VcSchema.class);
		
		id = data.id;
		schema = data.schema;
		title = data.title;
		description = data.description;
		metadata = data.metadata;
		credentialSubject = data.credentialSubject;
		
	}

}
