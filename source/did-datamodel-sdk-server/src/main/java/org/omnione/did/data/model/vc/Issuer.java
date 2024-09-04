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

@Getter
@Setter
public class Issuer extends DataObject{

    /**
     *  did
     */
    @SerializedName("id")
    @Expose @NotEmpty
    private String id;
    
    /**
     * Provide name
     */
    @SerializedName("name")
    @Expose
    private String name;

    @Override
    public void fromJson(String val) {
        GsonWrapper gson = new GsonWrapper();
        Issuer data = gson.fromJson(val, Issuer.class);
        
        id = data.id;
        name = data.name;
    }
}
