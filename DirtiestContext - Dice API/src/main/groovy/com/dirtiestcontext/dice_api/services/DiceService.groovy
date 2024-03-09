package com.dirtiestcontext.dice_api.services

import com.dirtiestcontext.dice_api.enums.Die
import com.dirtiestcontext.dice_api.models.Dice
import com.dirtiestcontext.dice_api.models.Roll
import groovy.util.logging.Slf4j
import org.springframework.stereotype.Service

@Slf4j
@Service
class DiceService {

	//create
	Dice buildDice(Roll roll) {
		log.info('Building Dice with Roll {}', roll)
		Dice dice = new Dice()
		//first build empty dice
		//then add the appropriate dice
	}

	private EnumMap<Die, Integer> buildEmptyDieMap() {
		log.info('Building Empty Die Map')
		EnumMap<Die, Integer> dieIntegerEnumMap
		dieIntegerEnumMap = Die.dieEnumSet.stream().forEach {
			dieIntegerEnumMap.put(it, 0)
		}
		dieIntegerEnumMap
	}

	private Dice buildDiceWithRoll(EnumMap<Die, Integer> baseEnumMap, Roll roll) {
		Dice dice = new Dice()
	}

	private EnumMap<Die, Integer> buildDieMapWithRoll(EnumMap<Die, Integer> baseEnumMap, Integer numberOfDie) {
		EnumMap<Die, Integer> builtEnumMap
	}

	//read
	//update
	//delete
	//deleteAll
}
