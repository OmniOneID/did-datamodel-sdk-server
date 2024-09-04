/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.profile;

import java.util.List;

import org.omnione.did.data.model.DataObject;
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
public class Process extends DataObject {

	/**
	 * Issuance API endpoint
	 */
	@SerializedName("endpoints")
	@Expose @NotEmpty
	private List<String> endpoints;

	/**
	 * E2E Request Information
	 */
	@SerializedName("reqE2e")
	@Expose @NotNull
	@Valid
	private ReqE2e reqE2e;

	@Override
	public void fromJson(String val) {
		GsonWrapper gson = new GsonWrapper();
		Process data = gson.fromJson(val, Process.class);

		endpoints = data.endpoints;
		reqE2e = data.reqE2e;

	}

}
