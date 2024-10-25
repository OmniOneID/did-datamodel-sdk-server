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

package org.omnione.did.data.model.vc;

import jakarta.validation.constraints.NotEmpty;

import java.util.Map;

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
public class DocumentVerificationEvidence extends Evidence {

	/**
	 * Name of required evidentiary documents
	 */
	@SerializedName("evidenceDocument")
	@Expose @NotEmpty
	private String evidenceDocument;

	/**
	 * How to identify the subject
	 * @see Presence
	 */
	@SerializedName("subjectPresence")
	@Expose @NotEmpty
	private String subjectPresence;

	/**
	 * How to submit required documents
	 * @see Presence
	 */
	@SerializedName("documentPresence")
	@Expose @NotEmpty
	private String documentPresence;

	/**
	 * The license number of the document
	 * @see Presence
	 */
	@SerializedName("attribute")
	@Expose
	private Map<String, String> attribute;

	@Override
	public void fromJson(String val) {
		super.fromJson(val);
		
		GsonWrapper gson = new GsonWrapper();
		DocumentVerificationEvidence data = gson.fromJson(val, DocumentVerificationEvidence.class);
		
		evidenceDocument = data.evidenceDocument;
		subjectPresence = data.subjectPresence;
		documentPresence = data.documentPresence;
		attribute = data.attribute;
	}

}
