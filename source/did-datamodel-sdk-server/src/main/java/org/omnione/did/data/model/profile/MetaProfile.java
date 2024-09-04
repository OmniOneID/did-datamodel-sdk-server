/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.profile;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import org.omnione.did.data.model.DataObject;
import org.omnione.did.data.model.enums.vc.Encoding;
import org.omnione.did.data.model.provider.LogoImage;
import org.omnione.did.data.model.util.json.GsonWrapper;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;
/**
 * @author 
 * Profile Metadata
 */

@Getter
@Setter
public class MetaProfile extends DataObject {

	/**
	 * UUID
	 */
	@SerializedName("id")
	@Expose @NotEmpty 
	private String id;

	/**
	 * ProfileType enum value
	 */
	@SerializedName("type")
	@Expose @NotEmpty 
	private String type;

	/**
	 * title
	 */
	@SerializedName("title")
	@Expose @NotNull
	private String title;

	/**
	 * description
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
	 * Encoding enums value
	 */
	@SerializedName("encoding")
	@Expose @NotEmpty 
	private String encoding = Encoding.UTF_8.getRawValue();

	/**
	 * Language enums value
	 */
	@SerializedName("language")
	@Expose @NotEmpty 
	private String language;

	@Override
	public void fromJson(String val) {
		GsonWrapper gson = new GsonWrapper();
		MetaProfile data = gson.fromJson(val, MetaProfile.class);
		id = data.id;
		type = data.type;
		title = data.title;
		description = data.description;
		encoding = data.encoding;
		language = data.language;

	}

}
