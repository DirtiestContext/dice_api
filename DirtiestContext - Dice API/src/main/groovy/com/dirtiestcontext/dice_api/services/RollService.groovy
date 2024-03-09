package com.dirtiestcontext.dice_api.services

import com.dirtiestcontext.dice_api.models.Roll
import com.dirtiestcontext.dice_api.requests.RollRequest
import groovy.util.logging.Slf4j
import org.springframework.stereotype.Service

@Slf4j
@Service
class RollService {

	//create
	Roll buildRoll(RollRequest rollRequest) {
		Roll newRoll = new Roll()
		newRoll.rollRequestArray = buildRollArray(buildRollList(rollRequest))
		newRoll
	}

	List<Integer> buildRollList(RollRequest rollRequest) {
		List<Integer> rollRequestList = rollRequest.findAll()
		rollRequestList
	}

	Integer[] buildRollArray(List<Integer> rollList) {
		Integer[] rollArray = new Integer[rollList.size()]
		rollList.toArray(rollArray)
		rollArray
	}

	//delete
}
