package com.dirtiestcontext.dice_api.models

import lombok.ToString

//is this the best way to do this?
//make part of a template?
@ToString
class Session {

	String sessionGUID
	List<Roll> listOfRolls
}
