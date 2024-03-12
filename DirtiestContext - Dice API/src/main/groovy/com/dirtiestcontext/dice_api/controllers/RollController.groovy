package com.dirtiestcontext.dice_api.controllers

import com.dirtiestcontext.dice_api.requests.RollRequest
import com.dirtiestcontext.dice_api.responses.RollResponse
import com.dirtiestcontext.dice_api.services.RollService
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

//research MDC
@Slf4j
@Controller
class RollController {

	@Autowired
	RollService rollService

	@PostMapping
	ResponseEntity<RollResponse> createRoll(@RequestBody RollRequest rollRequest) {
		log.info('Creating Roll')
		ResponseEntity<RollResponse> response
	}

	@GetMapping

}
