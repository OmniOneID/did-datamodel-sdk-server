/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.did;

import org.omnione.did.data.model.DataObject;
import org.omnione.did.data.model.provider.Provider;
import org.omnione.did.data.model.util.json.GsonWrapper;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvokedDidDoc extends DataObject {

    @SerializedName("didDoc")
    @Expose
    @NotEmpty
    private String didDoc;

    @SerializedName("controller")
    @Expose @NotNull
    @Valid
    private Provider controller;

    @SerializedName("proof")
    @Expose
    @Valid
    private Proof proof;

    @SerializedName("nonce")
    @Expose
    @NotEmpty
    private String nonce;

    public InvokedDidDoc(String didDoc, Proof proof, Provider controller, String nonce) {
        this.didDoc = didDoc;
        this.proof = proof;
        this.controller = controller;
        this.nonce = nonce;
    }

    @Override
    public void fromJson(String val) {
        GsonWrapper gson = new GsonWrapper();
        InvokedDidDoc data = gson.fromJson(val, InvokedDidDoc.class);
        didDoc = data.didDoc;
        proof = data.proof;
        controller = data.controller;
        nonce = data.nonce;
    }
}
