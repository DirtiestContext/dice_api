package com.dirtiestcontext.dice_api.utilities

import com.dirtiestcontext.dice_api.exceptions.EnumException
import groovy.util.logging.Slf4j
import org.springframework.stereotype.Component

@Component
@Slf4j
class EnumUtility {

	Boolean validateEnum(Enum<? extends Enum> enumToValidate, Class<?> enumClass) {
		String classAsAString = enumClass.simpleName
		if(enumToValidate != null) {
			return true
		}
		throw new EnumException('That is not a valid choice for' + classAsAString)
	}

	String validateParameter(Class<? extends Enum> enumClassParam, String enumName) {
		String classAsAString = enumClassParam.getSimpleName()
		try {
			String modifiedEnumName = enumName.toUpperCase().trim().replace('_', '')
			Enum.valueOf(enumClassParam, modifiedEnumName)
			modifiedEnumName
		} catch(IllegalArgumentException e) {
			log.warn('Caught Illegal Argument Exception message{}', e.getMessage())
			String exceptionMessage = 'That is not a valid choice for ' + classAsAString + ' error message = ' + e.message
			throw new EnumException(exceptionMessage)
		}
	}
}
