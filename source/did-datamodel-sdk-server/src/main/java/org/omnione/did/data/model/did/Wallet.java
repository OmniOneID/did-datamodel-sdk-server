/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.did;

import org.omnione.did.data.model.DataObject;
import org.omnione.did.data.model.util.json.GsonWrapper;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Wallet extends DataObject {

    @SerializedName("id")
    @Expose @NotEmpty
    private String id;

    @SerializedName("did")
    @Expose @NotEmpty
    @Valid
    private String did;

    @Override
    public void fromJson(String val) {
        GsonWrapper gson = new GsonWrapper();
        Wallet data = gson.fromJson(val, Wallet.class);
        id = data.id;
        did = data.did;
    }
}
