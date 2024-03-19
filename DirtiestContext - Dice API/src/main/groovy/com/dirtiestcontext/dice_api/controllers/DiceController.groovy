package com.dirtiestcontext.dice_api.controllers

import com.dirtiestcontext.dice_api.requests.RollRequest
import com.dirtiestcontext.dice_api.responses.RollResponse
import com.dirtiestcontext.dice_api.services.DiceService
import groovy.util.logging.Slf4j
import org.slf4j.MDC
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.web.access.intercept.RequestAuthorizationContext
import org.springframework.security.web.header.Header
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader

import java.net.http.HttpHeaders

//research MDC?
//integrate with swagger?
@Slf4j
@Controller
class DiceController {

	@Autowired
	DiceService diceService

	@PostMapping
	ResponseEntity<RollResponse> createRoll(@RequestBody RollRequest rollRequest,
	                                        @RequestHeader HttpHeaders headers) {
		String sessionId = headers.getAt('sessionId')
		MDC.put('sessionId', sessionId.toString())
		log.info('Creating Roll')

		new ResponseEntity<RollResponse>(diceService.wholeProcess(rollRequest), HttpStatus.OK)
	}

}
