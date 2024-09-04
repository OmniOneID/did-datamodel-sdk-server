/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.schema;

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
public class MetaData extends DataObject {
	/**
	 * VC language
	 */
	@SerializedName("language")
	@Expose @NotEmpty
	private String language;

	/**
	 * VC formatVersion
	 */
	@SerializedName("formatVersion")
	@Expose @NotEmpty
	private String formatVersion;

	@Override
	public void fromJson(String val) {
		GsonWrapper gson = new GsonWrapper();
		MetaData data = gson.fromJson(val, MetaData.class);

		language = data.language;
		formatVersion = data.formatVersion;

	}

}
