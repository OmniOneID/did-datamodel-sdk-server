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

package org.omnione.did.data.model.did.constants;

public class DateFormatConstants {
	// Regular expression
	public static final String DATA_FORMAT = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}(Z|\\.\\d{3,6}Z|[+-]\\d{2}:\\d{2})";
	public static final String VERSION_ID = "[1-9][0-9]*";
	// TODO To be modified
	public static final String DID_KEY_URL = "[a-zA-Z0-9:]+\\?versionId=[1-9][0-9]*#[a-zA-Z0-9]+";

	// Error message
	public static final String DATA_FORMAT_MESSAGE = "The string must match one of the following formats: yyyy-MM-dd'T'HH:mm:ss'Z', yyyy-MM-dd'T'HH:mm:ss.SSS'Z', yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z', or yyyy-MM-dd'T'HH:mm:ssXXX.";
	public static final String VERSION_ID_MESSAGE = "The string must contain digits starting from 1 and only digits from 0 to 9 are allowed";
	public static final String DID_KEY_URL_MESSAGE = "Invalid format. Must follow the pattern: did?versionId=[1-9]\\d*#didKeyId";

}
