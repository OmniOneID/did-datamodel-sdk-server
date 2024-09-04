/* 
 * Copyright 2024 Raonsecure
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
