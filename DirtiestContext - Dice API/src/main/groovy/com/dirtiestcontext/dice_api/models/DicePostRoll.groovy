package com.dirtiestcontext.dice_api.models

import com.dirtiestcontext.dice_api.enums.Die
import lombok.ToString

@ToString
class DicePostRoll {

	EnumMap<Die, Integer[]> rollResultsMap

}
