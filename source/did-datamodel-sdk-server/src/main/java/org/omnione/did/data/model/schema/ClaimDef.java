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

import java.util.Map;

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
public class ClaimDef extends DataObject {
	
	/**
	 * claim identifier
	 */
	@SerializedName("id")
	@Expose @NotEmpty
	private String id;

	/**
	 * claim name
	 */
	@SerializedName("caption")
	@Expose @NotEmpty
	private String caption;


	/**
	 * ClaimType enum value
	 */
	@SerializedName("type")
	@Expose @NotEmpty	
	private String type;

	/**
	 * ClaimFormat enum value
	 */
	@SerializedName("format")
	@Expose @NotEmpty
	private String format;

	/**
	 * Whether claim value is hidden
	 */
	@SerializedName("hideValue")
	@Expose
	private boolean hideValue;

	/**
	 * Claim origin location
	 * Location enum value
	 */
	@SerializedName("location")
	@Expose
	private String location;

	/**
	 * true - Mandatory claim
	 */
	@SerializedName("required")
	@Expose
	private Boolean required;

	/**
	 * description
	 */
	@SerializedName("description")
	@Expose
	private String description;

	/**
	 * Claim names in other languages
	 */
	@SerializedName("i18n")
	@Expose 
	private Map<String, String> i18n;

	
	@Override
	public void fromJson(String val) {
		GsonWrapper gson = new GsonWrapper();
		ClaimDef data = gson.fromJson(val, ClaimDef.class);
		id = data.id;
		caption = data.caption;
		type = data.type;
		format = data.format;
		hideValue = data.hideValue;
		location = data.location;
		required = data.required;
		description = data.description;
		i18n = data.i18n;

	}

}
