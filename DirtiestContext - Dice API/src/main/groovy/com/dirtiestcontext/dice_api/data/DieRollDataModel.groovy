package com.dirtiestcontext.dice_api.data

import com.dirtiestcontext.dice_api.enums.Die
import lombok.Data

@Data
class DieRollDataModel {

	Long ID
	Die die
	Integer rollResult

}
