package com.dirtiestcontext.dice_api.models

import com.dirtiestcontext.dice_api.enums.Die
import lombok.ToString

@ToString
class Dice {

	//Integer is number of that specific Die to roll
	public static EnumMap<Die, Integer> dieToRoll
}
