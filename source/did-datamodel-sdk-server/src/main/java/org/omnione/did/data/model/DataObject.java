/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model;

import org.omnione.did.data.model.util.json.GsonWrapper;
import org.omnione.did.data.model.util.json.JsonSortUtil;

public abstract class DataObject {

	public String toJson() {
		GsonWrapper gson = new GsonWrapper();
		String json = gson.toJson(this);

		return JsonSortUtil.sortJsonString(gson, json);

	}

	public abstract void fromJson(String val);
}
