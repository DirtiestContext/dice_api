package com.dirtiestcontext.dice_api.maps

import com.dirtiestcontext.dice_api.enums.Die
import com.dirtiestcontext.dice_api.models.DicePreRoll
import com.dirtiestcontext.dice_api.requests.RollRequest
import groovy.util.logging.Slf4j
import org.springframework.stereotype.Service

@Slf4j
@Service
class DiceMappingService {

	DicePreRoll mapRollRequestToDicePreRoll(RollRequest rollRequest, EnumMap<Die, Integer> dieMap) {
		DicePreRoll dicePreRoll = new DicePreRoll()
		EnumMap<Die, Integer> updatedMap = new EnumMap<>(dieMap)
		updatedMap.replace(Die.D2, rollRequest.numberOfD2)
		updatedMap.replace(Die.D4, rollRequest.numberOfD4)
		updatedMap.replace(Die.D5, rollRequest.numberOfD5)
		updatedMap.replace(Die.D6, rollRequest.numberOfD6)
		updatedMap.replace(Die.D8, rollRequest.numberOfD8)
		updatedMap.replace(Die.D10, rollRequest.numberOfD10)
		updatedMap.replace(Die.D12, rollRequest.numberOfD12)
		updatedMap.replace(Die.D20, rollRequest.numberOfD20)
		updatedMap.replace(Die.D100, rollRequest.numberOfD100)
		dicePreRoll.dieToRoll == updatedMap
		dicePreRoll
	}
}
