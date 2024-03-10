package com.dirtiestcontext.dice_api.data

import com.dirtiestcontext.dice_api.models.Roll

class SessionDataModel {

	Long sessionID
	String sessionGUID
	String userName
	Integer numberOfRolls
	List<Roll> rollList

}
