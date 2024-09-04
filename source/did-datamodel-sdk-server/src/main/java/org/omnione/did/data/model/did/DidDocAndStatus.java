/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.did;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.omnione.did.data.model.DataObject;
import org.omnione.did.data.model.enums.did.DidDocStatus;
import org.omnione.did.data.model.util.json.GsonWrapper;

@Getter
@Setter
@NoArgsConstructor
public class DidDocAndStatus extends DataObject {


    @Expose
    @SerializedName("document")
    private DidDocument document;

    @Expose
    @SerializedName("status")
    private DidDocStatus status;

    public DidDocAndStatus(DidDocument document, DidDocStatus status) {
        this.document = document;
        this.status = status;
    }

    @Override
    public void fromJson(String val) {
        GsonWrapper gson = new GsonWrapper();
        DidDocAndStatus data = gson.fromJson(val, DidDocAndStatus.class);
        document = data.document;
        status = data.status;
    }
}
