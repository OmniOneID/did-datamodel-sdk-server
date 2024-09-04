/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.profile.issue;

import org.omnione.did.data.model.did.Proof;
import org.omnione.did.data.model.profile.MetaProfile;
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
public class IssueProfile extends MetaProfile {


	/**
	 * Profile Contents
	 */
	@SerializedName("profile")
	@Expose @NotNull
	@Valid
	private InnerIssueProfile profile;

	
	/**
	 * issuer signature for profile
	 */
	@SerializedName("proof")
	@Expose @NotNull
	private Proof proof;

	@Override
	public void fromJson(String val) {
		super.fromJson(val);

		GsonWrapper gson = new GsonWrapper();
		IssueProfile data = gson.fromJson(val, IssueProfile.class);

		profile = data.profile;
		proof = data.proof;
	}

}
