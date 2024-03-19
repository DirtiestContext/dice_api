package com.dirtiestcontext.dice_api.utilities

import com.dirtiestcontext.dice_api.exceptions.BooleanException
import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter
class BooleanConverterUtility implements AttributeConverter<Boolean,Character> {

	@Override
	Character convertToDatabaseColumn(Boolean attribute) {
		Character yesOrNO = null
		if(attribute) {
			(yesOrNO = 'Y') as Character
		} else if(!attribute) {
			 yesOrNO = 'N' as Character
		} else if(attribute == null){
			throw new BooleanException('An appropriate option for the flag was not entered.')
		}
		yesOrNO
	}

	@Override
	Boolean convertToEntityAttribute(Character dbData) {
		String dbDataAsString = dbData
		dbDataAsString.trim()
		Boolean data = null
		if(dbDataAsString == 'Y') {
			data = true
		}else if(dbDataAsString == 'N') {
			data = false
		} else if(data == null) {
			throw new BooleanException('An appropriate option for the flag was not entered.')
		}
		data
	}
}
