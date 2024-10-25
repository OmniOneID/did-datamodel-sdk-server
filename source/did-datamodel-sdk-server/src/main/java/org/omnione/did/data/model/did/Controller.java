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
