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

package org.omnione.did.data.model.util.json;

import java.lang.reflect.Type;
import java.util.Set;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;
import org.omnione.did.data.model.enums.vc.EvidenceType;
import org.omnione.did.data.model.vc.DocumentVerificationEvidence;
import org.omnione.did.data.model.vc.Evidence;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonSyntaxException;

public class GsonWrapper {
	public static GsonWrapper getGson() {
		return new GsonWrapper();
	}

	public static GsonWrapper getGsonPrettyPrinting() {
		return new GsonWrapper(true);
	}

	private Gson gson;
	private Validator validator;

	public GsonWrapper() {
		super();
		gson = new GsonBuilder().disableHtmlEscaping().excludeFieldsWithoutExposeAnnotation()
		    .registerTypeAdapter(Evidence.class, new EvidenceTypeAdapter()).create();
		validator = Validation.byDefaultProvider()
	            .configure().messageInterpolator(new ParameterMessageInterpolator()).buildValidatorFactory().getValidator();
	}

	public GsonWrapper(boolean prettyPrinting) {
		super();
		GsonBuilder builder = new GsonBuilder().disableHtmlEscaping();
		if (prettyPrinting) {
			builder.setPrettyPrinting();
		}
		gson = builder.create();
		validator = Validation.byDefaultProvider()
	            .configure().messageInterpolator(new ParameterMessageInterpolator()).buildValidatorFactory().getValidator();
	}

	public <T> T fromJson(String json, Class<T> classOfT) throws JsonSyntaxException {
		T obj = gson.fromJson(json, classOfT);
		validate(obj);
		return obj;
	}

	public String toJson(Object src) {
		validate(src);
		return gson.toJson(src);
	}

	public <T> void validate(T obj) throws ConstraintViolationException {
		Set<ConstraintViolation<T>> violations = validator.validate(obj);
		if (!violations.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			for (ConstraintViolation<T> violation : violations) {
				// sb.append(violation.getMessage()).append("\n");

				String propertyPath = violation.getPropertyPath().toString();
				Object invalidValue = violation.getInvalidValue();
				String invalidValueStr = (invalidValue == null) ? "null" : invalidValue.toString();
				String message = violation.getMessage();
				sb.append("Property '").append(propertyPath).append("' with value '").append(invalidValueStr)
						.append("' ").append(message).append("\n");
			}
			throw new ConstraintViolationException(sb.toString(), violations);

		}
	}
	
    private static class EvidenceTypeAdapter implements JsonSerializer<Evidence>, JsonDeserializer<Evidence> {
      @Override
      public JsonElement serialize(Evidence src, Type typeOfSrc, JsonSerializationContext context) {
          JsonObject jsonObject = context.serialize(src).getAsJsonObject();
          return jsonObject;
      }

      @Override
      public Evidence deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
          JsonObject jsonObject = json.getAsJsonObject();
          String type = jsonObject.get("type").getAsString();
          if (EvidenceType.DOCUMENT_VERIFICATION.getRawValue().equals(type)) {
            return context.deserialize(jsonObject, DocumentVerificationEvidence.class);
        } else {
            return null;
        }
      }
  }
}