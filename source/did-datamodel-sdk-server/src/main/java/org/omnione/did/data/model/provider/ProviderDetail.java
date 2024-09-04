/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.provider;

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
public class ProviderDetail extends Provider {

	/**
	 * Provide name
	 */
	@SerializedName("name")
	@Expose
	private String name;

	/**
	 * Provide description
	 */
	@SerializedName("description")
	@Expose
	private String description;

	/**
	 * logo image
	 */
	@SerializedName("logo")
	@Expose
	private LogoImage logo;

	/**
	 * reference URL
	 */
	@SerializedName("ref")
	@Expose
	private String ref;

	@Override
	public void fromJson(String val) {
		super.fromJson(val);

		GsonWrapper gson = new GsonWrapper();
		ProviderDetail data = gson.fromJson(val, ProviderDetail.class);

		name = data.name;
		description = data.description;
		logo = data.logo;
		ref = data.ref;

	}

}
