/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.profile.verify;

import org.omnione.did.data.model.DataObject;
import org.omnione.did.data.model.profile.Filter;
import org.omnione.did.data.model.provider.ProviderDetail;
import org.omnione.did.data.model.util.json.GsonWrapper;

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
public class InnerVerifyProfile extends DataObject {

	/**
	 * verifier Infos
	 */
	@SerializedName("verifier")
	@Expose @NotNull
	@Valid
	private ProviderDetail verifier;

	/**
	 * Filters to select VCs to submit
	 */
	@SerializedName("filter")
	@Expose
	private Filter filter;
	
	/**
	 * How to Submit a VP
	 */
	@SerializedName("process")
	@Expose
	private VerifyProcess process;

	@Override
	public void fromJson(String val) {
		GsonWrapper gson = new GsonWrapper();
		InnerVerifyProfile data = gson.fromJson(val, InnerVerifyProfile.class);

		verifier = data.verifier;
		filter = data.filter;
	}

}
