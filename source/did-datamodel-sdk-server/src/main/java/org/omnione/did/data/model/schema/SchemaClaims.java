/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.schema;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
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
public class SchemaClaims extends DataObject {
	/**	 
	 * Claims by namespace
	 */
	@SerializedName("namespace")
	@Expose @NotNull
	@Valid
	private Namespace namespace;

	/**	 
	 * List of Claim Definitions
	 */
	@SerializedName("items")
	@Expose @NotNull
	@Size(min = 1, message = "The array must have at least one element")
	private List<@Valid ClaimDef> items;

	@Override
	public void fromJson(String val) {
		GsonWrapper gson = new GsonWrapper();
		SchemaClaims data = gson.fromJson(val, SchemaClaims.class);

		namespace = data.namespace;
		items = data.items;

	}

}
