/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.did;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.omnione.did.data.model.DataObject;
import org.omnione.did.data.model.util.json.GsonWrapper;

import jakarta.validation.constraints.NotEmpty;

@Getter
@Setter
public class Controller extends DataObject {

    @SerializedName("did")
    @Expose
    @NotEmpty
    private String did;

    @SerializedName("certVcRef")
    @Expose
    @NotEmpty
    private String certVcRef;

    @Builder
    public Controller(String did, String certVcRef) {
        this.did = did;
        this.certVcRef = certVcRef;
    }

    @Override
    public void fromJson(String val) {
        GsonWrapper gson = new GsonWrapper();
        Controller data = gson.fromJson(val, Controller.class);
        did = data.did;
        certVcRef = data.certVcRef;
    }
}
