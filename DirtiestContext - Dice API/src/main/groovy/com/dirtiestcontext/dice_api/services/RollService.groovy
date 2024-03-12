package com.dirtiestcontext.dice_api.services

import com.dirtiestcontext.dice_api.models.Roll
import com.dirtiestcontext.dice_api.requests.RollRequest
import com.dirtiestcontext.dice_api.responses.RollResponse
import com.dirtiestcontext.dice_api.respositories.RollRepository
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@Slf4j
@Service
class RollService {

	@Autowired
	RollRepository rollRepository

	//create
	Roll createRollFromRequest(RollRequest rollRequest) {
		Integer[] rollArray = new Integer[9]
		Roll roll = new Roll()
		rollArray[0] == rollRequest.numberOfD2
		rollArray[1] == rollRequest.numberOfD4
		rollArray[2] == rollRequest.numberOfD5
		rollArray[3] == rollRequest.numberOfD6
		rollArray[4] == rollRequest.numberOfD8
		rollArray[5] == rollRequest.numberOfD10
		rollArray[6] == rollRequest.numberOfD12
		rollArray[7] == rollRequest.numberOfD20
		rollArray[8] == rollRequest.numberOfD100
		roll.rollRequestArray = rollArray
		roll
	}
	//read
	List<Integer> readRollArray(Roll roll) {
		List<Integer> rollList = new ArrayList<>(9)
		for(Integer numberOfDie : roll.rollRequestArray) {
			rollList.add(numberOfDie)
		}
		rollList
	}
	//update
	Roll updateRollArray(Roll roll, int arrayIndex, Integer newNumberOfDie) {
		roll.rollRequestArray[arrayIndex] == newNumberOfDie
		roll
	}
	//delete
	void deleteRoll(Roll roll) {

	}
}
