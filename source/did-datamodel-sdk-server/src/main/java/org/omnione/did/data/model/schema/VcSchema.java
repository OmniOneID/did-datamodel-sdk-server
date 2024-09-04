/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.schema;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

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
public class VcSchema extends DataObject{
	
	/**
	 * VC schema URL
	 */
	@SerializedName("@id")
	@Expose @NotEmpty
	private String id;
	
	/**
	 *  VC Schema format URL(osd url)
	 */
	@SerializedName("@schema")
	@Expose @NotEmpty
	private String schema;
	
	/**
	 * schema name
	 */
	@SerializedName("title")
	@Expose @NotEmpty
	private String title;
	
	/**
	 * description
	 */
	@SerializedName("description")
	@Expose @NotEmpty
	private String description;
	
	/**
	 * metadata
	 */
	@SerializedName("metadata")
	@Expose @NotNull
	@Valid
	private MetaData metadata;
	
	/**
	 * metadata
	 */
	@SerializedName("credentialSubject")
	@Expose @NotNull
	@Valid
	private SchemaCredentialSubject credentialSubject;
	
	@Override
	public void fromJson(String val) {
		GsonWrapper gson = new GsonWrapper();
		VcSchema data = gson.fromJson(val, VcSchema.class);
		
		id = data.id;
		schema = data.schema;
		title = data.title;
		description = data.description;
		metadata = data.metadata;
		credentialSubject = data.credentialSubject;
		
	}

}
