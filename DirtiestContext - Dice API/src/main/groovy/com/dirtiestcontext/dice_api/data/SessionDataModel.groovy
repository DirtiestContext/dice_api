package com.dirtiestcontext.dice_api.data

import com.dirtiestcontext.dice_api.models.Roll
import lombok.Data

@Data
class SessionDataModel {

	Long sessionID
	String sessionGUID
	String userName
	Integer numberOfRolls
	List<Roll> rollList

}
