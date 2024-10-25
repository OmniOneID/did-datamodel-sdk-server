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
