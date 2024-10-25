/*
 * Copyright 2024 OmniOne.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
