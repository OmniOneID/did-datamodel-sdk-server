/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.vp;

import org.omnione.did.data.model.did.Proof;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 
 */

@Getter
@Setter

public class VpProof extends Proof {

	public void fromJson(String val) {
		super.fromJson(val);

	}

}
