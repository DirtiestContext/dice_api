package com.dirtiestcontext.dice_api.data

import com.dirtiestcontext.dice_api.models.Dice
import lombok.Data

@Data
class RollDataModel {

	Long ID
	String sessionGuid
	Dice dice
	Long diceTotal
}
