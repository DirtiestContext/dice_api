package com.dirtiestcontext.dice_api.requests

import lombok.ToString

@ToString
class RollRequest {

	Integer numberOfD2
	Integer numberOfD4
	Integer numberOfD6
	Integer numberOfD8
	Integer numberOfD10
	Integer numberOfD12
	Integer numberOfD20
	Integer numberOfD100
}
