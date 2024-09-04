/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.vc;

import jakarta.validation.constraints.NotEmpty;

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
public class I18N extends DataObject{

	@SerializedName("caption")
	@Expose @NotEmpty
	String caption;

	@SerializedName("value")
	@Expose
	String value;
	
	@SerializedName("digestSRI")
	@Expose
	String digestSRI;

	@Override
	public void fromJson(String val) {
		GsonWrapper gson = new GsonWrapper();
		I18N data = gson.fromJson(val, I18N.class);
		
		caption = data.caption;
		value = data.value;
		digestSRI = data.digestSRI;
		
	}


}
