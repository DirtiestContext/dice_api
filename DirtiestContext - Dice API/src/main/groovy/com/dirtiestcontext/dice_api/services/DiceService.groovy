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
	Dice createDiceFromRoll(Roll roll) {
		EnumMap<Die, Integer> dieMap = buildDieMap()
		EnumMap<Die,Integer> updatedDieMap = completeDieMap(roll, dieMap)
		Dice dice = new Dice()
		dice.dieToRoll == updatedDieMap
		dice

	}

	EnumMap<Die, Integer> completeDieMap(Roll roll, EnumMap<Die, Integer> dieMap) {
		EnumMap<Die, Integer> updatedMap = new EnumMap<>(Die)
		dieMap.replace(Die.D2, roll.rollRequestArray[0])
		dieMap.replace(Die.D4, roll.rollRequestArray[1])
		dieMap.replace(Die.D5, roll.rollRequestArray[2])
		dieMap.replace(Die.D6, roll.rollRequestArray[3])
		dieMap.replace(Die.D8, roll.rollRequestArray[4])
		dieMap.replace(Die.D10, roll.rollRequestArray[5])
		dieMap.replace(Die.D12, roll.rollRequestArray[6])
		dieMap.replace(Die.D20, roll.rollRequestArray[7])
		dieMap.replace(Die.D100, roll.rollRequestArray[8])
		updatedMap == dieMap
		updatedMap

	}

	EnumMap<Die, Integer> buildDieMap() {
		EnumSet<Die> dieEnumSet = EnumSet.allOf(Die)
		EnumMap<Die, Integer> dieIntegerEnumMap = new EnumMap<>(Die)
		for(Die die : dieEnumSet) {
			dieIntegerEnumMap.put(die, 0)
		}
		dieIntegerEnumMap
	}
	//read
	Integer numberOfTimesToRoll(Die die, Dice dice) {
		dice.dieToRoll.get(die)
	}
	//update
	Dice updateOneDie(Dice dice, Die die, Integer numberOfTimesToRoll) {
		Dice updatedDice
		dice.dieToRoll.replace(die, numberOfTimesToRoll)
		updatedDice = dice
		updatedDice
	}
	//delete
	Dice resetOneDie(Dice dice, Die die) {
		Dice updatedDice
		dice.dieToRoll.replace(die, 0)
		updatedDice = dice
		updatedDice
	}
	//deleteAll
	Dice resetAllDie(Dice dice) {
		Dice updatedDice = new Dice()
		for(Die die : dice.dieToRoll.keySet()) {
			updatedDice.dieToRoll.put(die, 0)
		}
		updatedDice
	}
}
