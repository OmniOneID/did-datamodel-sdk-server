/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.schema;

import java.util.List;

import jakarta.validation.Valid;
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
public class SchemaCredentialSubject extends DataObject{

	/**	 
	 * VC Schema URL
	 */
	@SerializedName("claims")
	@Expose
	@Size(min = 1, message = "The array must have at least one element")
	private List<@Valid SchemaClaims> claims;
	
	@Override
	public void fromJson(String val) {
		GsonWrapper gson = new GsonWrapper();
		SchemaCredentialSubject data = gson.fromJson(val, SchemaCredentialSubject.class);
		
		claims = data.claims;
		
	}

}
