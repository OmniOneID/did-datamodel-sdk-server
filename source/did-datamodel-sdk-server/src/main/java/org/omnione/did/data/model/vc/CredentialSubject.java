/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.vc;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

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
public class CredentialSubject extends DataObject {

	/**
	 * subject did
	 */
	@SerializedName("id")
	@Expose @NotEmpty
	private String id;

	/**
	 * Required Claim List
	 */
	@SerializedName("claims")
	@Expose @Size(min = 1, message = "The array must have at least one element")
	private List<@Valid Claim> claims;

	@Override
	public void fromJson(String val) {
		GsonWrapper gson = new GsonWrapper();
		CredentialSubject data = gson.fromJson(val, CredentialSubject.class);
		
		id = data.id;
		claims = data.claims;


	}

}
