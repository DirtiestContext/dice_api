package com.dirtiestcontext.dice_api.services

import com.dirtiestcontext.dice_api.enums.Die
import com.dirtiestcontext.dice_api.maps.DiceMappingService
import com.dirtiestcontext.dice_api.maps.RollMappingService
import com.dirtiestcontext.dice_api.models.DicePostRoll
import com.dirtiestcontext.dice_api.models.DicePreRoll
import com.dirtiestcontext.dice_api.requests.RollRequest
import com.dirtiestcontext.dice_api.responses.RollResponse
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Slf4j
@Service
class DiceService {

	@Autowired
	DiceMappingService diceMappingService

	@Autowired
	RollMappingService rollMappingService

	@Autowired
	RollService rollService

	RollResponse wholeProcess(RollRequest rollRequest) {
		DicePreRoll dicePreRoll = buildDicePreRoll(rollRequest)
		DicePostRoll dicePostRoll = rollingTheDice(dicePreRoll)

		buildRollResponse(dicePostRoll)
	}

	DicePreRoll buildDicePreRoll(RollRequest rollRequest) {
		diceMappingService.mapRollRequestToDicePreRoll(rollRequest, buildEmptyDieMap())
	}

	DicePostRoll rollingTheDice(DicePreRoll dicePreRoll) {
		EnumMap<Die, Integer> dieMap = dicePreRoll.dieToRoll
		DicePostRoll dicePostRoll = new DicePostRoll()
		EnumMap<Die, Integer[]> resultsMap = new EnumMap<>(Die)

		for(Die die : dieMap.keySet()) {
			Integer numberOfTimesToRoll = dieMap.get(die)
			Integer[] resultsArray = rollService.resultsArrayPerDie(die, numberOfTimesToRoll)
			resultsMap.put(die, resultsArray)
		}

		dicePostRoll.rollResultsMap = resultsMap
		dicePostRoll
	}

	RollResponse buildRollResponse(DicePostRoll dicePostRoll) {
		EnumMap<Die, Integer> dieRollTotals = resultsTotalsPerDie(dicePostRoll)
		Long rollTotal = rollResultTotal(dieRollTotals)

		//save the RollDataModel here eventually
		rollMappingService.mapDicePostRollToRollResponse(dicePostRoll, dieRollTotals, rollTotal)
	}

	EnumMap<Die, Integer> buildEmptyDieMap() {
		EnumSet<Die> dieSet = EnumSet.allOf(Die)
		EnumMap<Die, Integer> dieMap = new EnumMap<>(Die)
		for(Die die : dieSet) {
			dieMap.put(die, 0)
		}
		dieMap
	}

	EnumMap<Die, Integer> resultsTotalsPerDie(DicePostRoll dicePostRoll) {
		EnumMap<Die, Integer> totalsMap = new EnumMap<>(Die)
		EnumMap<Die, Integer[]> rollResultsMap = dicePostRoll.rollResultsMap
		for(Die die : rollResultsMap.keySet()) {
			Integer rollTotal = rollService.resultOfAllRollsPerDie(rollResultsMap.get(die))
			totalsMap.put(die, rollTotal)
		}
		totalsMap
	}

	Long rollResultTotal(EnumMap<Die, Integer> totalsMap) {
		rollService.resultsTotalOfRoll(totalsMap)
	}

}
