package com.dirtiestcontext.dice_api.services

import com.dirtiestcontext.dice_api.enums.Die
import com.dirtiestcontext.dice_api.models.DicePostRoll
import com.dirtiestcontext.dice_api.models.DicePreRoll
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import java.util.concurrent.ThreadLocalRandom

//Place the logic behind rolling the dice here

@Slf4j
@Service
class RollService {

	//the actual die roll
	Integer roll(Die die) {
		Integer numberOfSides = Die.returnNumberOfSides(die)
		//lower bound inclusive, upper bond exclusive
		Integer rollResult = ThreadLocalRandom.current().nextInt(1, (numberOfSides + 1))
		//save this eventually
		rollResult
	}

	Integer[] resultsArrayPerDie(Die die, Integer numberOfTimesToRoll) {
		if(numberOfTimesToRoll > 0) {
			Integer[] resultsForDieRolls = new Integer[numberOfTimesToRoll]
			int index
			for(index = 0; index < numberOfTimesToRoll; index++){
				resultsForDieRolls[index] = roll(die)
			}
			resultsForDieRolls
		} else {
			Integer[] resultsForDieRolls = new Integer[1]
			resultsForDieRolls[0] = 0
			resultsForDieRolls
		}
	}

	Integer resultOfAllRollsPerDie(Integer[] resultsArray) {
		Integer resultsTotal = 0
		for(Integer rollResult : resultsArray) {
			resultsTotal = resultsTotal + rollResult
		}
		resultsTotal
	}

	Long resultsTotalOfRoll(EnumMap<Die, Integer> resultsMap) {
		Long totalOfRoll = 0
		for(Die die : resultsMap.keySet()) {
			totalOfRoll = totalOfRoll + resultsMap.get(die)
		}
		totalOfRoll
	}


}
