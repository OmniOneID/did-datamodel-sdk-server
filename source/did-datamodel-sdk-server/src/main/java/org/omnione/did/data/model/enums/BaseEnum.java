/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.data.model.enums;

import java.util.EnumSet;

public interface BaseEnum {

	public int getRawValue();

	public static <T extends Enum<T> & BaseEnum> T fromString(Class<T> enumClass, int text) {
		for (T b : EnumSet.allOf(enumClass)) {
			if (b.getRawValue() == text) {
				return b;
			}
		}
		return null;
	}

	public static <T extends Enum<T> & BaseEnum> EnumSet<T> all(Class<T> enumClass) {
		return EnumSet.allOf(enumClass);
	}
}