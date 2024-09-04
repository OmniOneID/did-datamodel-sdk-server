/* 
 * Copyright 2024 Raonsecure
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
