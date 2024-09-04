/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.did;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
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
public class Service extends DataObject{

	/**
	 * service id
	 */
	@SerializedName("id")
    @Expose @NotEmpty
    private String id;
		
	/**
	 * enum DIDServiceType value
	 */
	@SerializedName("type")
    @Expose @NotEmpty
    private String type; 
	
	/**
	 * DID service locator 
	 * list of URL to the service
	 * DidKeyUrl consists of did, versionId, and didServiceId.
	 */
	@SerializedName("serviceEndpoint")
    @Expose 
    @Size(min = 1)
    private List<String> serviceEndpoint;

	@Override
	public void fromJson(String val) {
		GsonWrapper gson = new GsonWrapper();
		Service data = gson.fromJson(val, Service.class);
		
		id = data.id;
		type = data.type;
		serviceEndpoint = data.serviceEndpoint;
	}

}
