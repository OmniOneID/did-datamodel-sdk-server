/* 
 * Copyright 2024 Raonsecure
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
