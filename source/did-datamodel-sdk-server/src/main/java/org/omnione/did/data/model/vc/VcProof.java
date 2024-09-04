/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.vc;

import java.util.List;

import org.omnione.did.data.model.did.Proof;
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
public class VcProof extends Proof {

	/**
	 * Signature for individual claims
	 */
	@SerializedName("proofValueList")
	@Expose
	private List<String> proofValueList;
	
	public void fromJson(String val) {
		super.fromJson(val);

		GsonWrapper gson = new GsonWrapper();
		VcProof data = gson.fromJson(val, VcProof.class);

		proofValueList = data.proofValueList;

	}

}
