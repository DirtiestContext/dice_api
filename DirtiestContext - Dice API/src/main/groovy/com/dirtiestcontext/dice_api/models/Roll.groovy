package com.dirtiestcontext.dice_api.models

import lombok.ToString

@ToString
class Roll {

	//fixed indices [0] = D2, [1] = D4 etc.
	Integer[] rollRequestArray

}
