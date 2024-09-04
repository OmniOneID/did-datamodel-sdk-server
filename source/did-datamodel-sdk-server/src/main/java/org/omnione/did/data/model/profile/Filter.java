/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.profile;

import java.util.List;

import org.omnione.did.data.model.DataObject;
import org.omnione.did.data.model.util.json.GsonWrapper;
import org.omnione.did.data.model.vc.CredentialSchema;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
/**
 * @author 
 */

@Getter
@Setter
public class Filter extends DataObject {

	/**
	 * Claims and issuers for each VC Schema that can be submitted
	 */
	@SerializedName("credentialSchemas")
	@Expose @NotNull
	private List<@Valid CredentialSchema> credentialSchemas;

	@Override
	public void fromJson(String val) {
		GsonWrapper gson = new GsonWrapper();
		Filter data = gson.fromJson(val, Filter.class);

		credentialSchemas = data.credentialSchemas;

	}

}
