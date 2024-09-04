/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.provider;

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
public class LogoImage extends Provider {

	/**
	 * LogoImageType enum value
	 */
	@SerializedName("format")
	@Expose @NotEmpty
	private String format;

	/**
	 * logo image URL
	 */
	@SerializedName("link")
	@Expose
	private String link;

	/**
	 * multibase(image)
	 */
	@SerializedName("value")
	@Expose
	private String value;

	@Override
	public void fromJson(String val) {
		super.fromJson(val);

		GsonWrapper gson = new GsonWrapper();
		LogoImage data = gson.fromJson(val, LogoImage.class);

		format = data.format;
		link = data.link;
		value = data.value;
	}

}
