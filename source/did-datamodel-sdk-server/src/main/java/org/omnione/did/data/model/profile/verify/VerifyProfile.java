/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.profile.verify;

import org.omnione.did.data.model.did.Proof;
import org.omnione.did.data.model.profile.MetaProfile;
import org.omnione.did.data.model.util.json.GsonWrapper;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
/**
 * @author 
 */

@Getter
@Setter
public class VerifyProfile extends MetaProfile {

	/**	 
	 * Profile Contents
	 */
	@SerializedName("profile")
	@Expose @NotNull
	@Valid
	private InnerVerifyProfile profile;

	/**	 
	 * 	verifier signature for profile
	 */
	@SerializedName("proof")
	@Expose @NotNull
	private Proof proof;

	@Override
	public void fromJson(String val) {
		super.fromJson(val);
		
		GsonWrapper gson = new GsonWrapper();
		VerifyProfile data = gson.fromJson(val, VerifyProfile.class);

		profile = data.profile;
		proof = data.proof;

	}

}
