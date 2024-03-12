package com.dirtiestcontext.dice_api.maps

import com.dirtiestcontext.dice_api.enums.Die
import com.dirtiestcontext.dice_api.models.DicePostRoll
import com.dirtiestcontext.dice_api.responses.RollResponse
import groovy.util.logging.Slf4j
import org.springframework.stereotype.Service

@Slf4j
@Service
class RollMappingService {

	RollResponse mapDicePostRollToRollResponse(DicePostRoll dicePostRoll, EnumMap<Die, Integer> dieTotals, Long rollTotal) {
		RollResponse rollResponse = new RollResponse()
		EnumMap<Die, Integer[]> dieResultsMap = dicePostRoll.rollResultsMap
		rollResponse.d2Results = dieResultsMap.get(Die.D2)
		rollResponse.d2Total = dieTotals.get(Die.D2)
		rollResponse.d4Results = dieResultsMap.get(Die.D4)
		rollResponse.d4Total = dieTotals.get(Die.D4)
		rollResponse.d5Results = dieResultsMap.get(Die.D5)
		rollResponse.d5Total = dieTotals.get(Die.D5)
		rollResponse.d6Results = dieResultsMap.get(Die.D6)
		rollResponse.d6Total = dieTotals.get(Die.D6)
		rollResponse.d8Results = dieResultsMap.get(Die.D8)
		rollResponse.d8Total = dieTotals.get(Die.D8)
		rollResponse.d10Results = dieResultsMap.get(Die.D10)
		rollResponse.d10Total = dieTotals.get(Die.D10)
		rollResponse.d12Results = dieResultsMap.get(Die.D12)
		rollResponse.d12Total = dieTotals.get(Die.D12)
		rollResponse.d20Results = dieResultsMap.get(Die.D20)
		rollResponse.d20Total = dieTotals.get(Die.D20)
		rollResponse.d100Results = dieResultsMap.get(Die.D100)
		rollResponse.d100Total = dieTotals.get(Die.D100)
		rollResponse.rollTotal = rollTotal
		rollResponse
	}
}
