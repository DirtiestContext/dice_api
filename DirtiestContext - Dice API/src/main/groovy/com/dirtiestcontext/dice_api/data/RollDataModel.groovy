package com.dirtiestcontext.dice_api.data

import com.dirtiestcontext.dice_api.models.DicePostRoll
import lombok.Data

@Data
class RollDataModel {

	Long ID
	String sessionGuid
	DicePostRoll dice
	Long diceTotal
}
