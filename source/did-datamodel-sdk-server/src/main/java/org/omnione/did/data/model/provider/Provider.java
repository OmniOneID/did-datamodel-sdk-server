/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.provider;

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
public class Provider extends DataObject{
	
	/**
	 *  did
	 */
	@SerializedName("did")
	@Expose @NotEmpty
	private String did;
		
	/**
	 * Verifier’s VC URL
	 */
	@SerializedName("certVcRef")
	@Expose
	private String certVcRef;
	
	@Override
	public void fromJson(String val) {
		GsonWrapper gson = new GsonWrapper();
		Provider data = gson.fromJson(val, Provider.class);
		
		did = data.did;
		certVcRef = data.certVcRef;
		
	}

}
