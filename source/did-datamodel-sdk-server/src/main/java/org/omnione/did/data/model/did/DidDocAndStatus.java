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
