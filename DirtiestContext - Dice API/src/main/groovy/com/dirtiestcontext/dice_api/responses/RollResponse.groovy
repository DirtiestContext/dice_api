package com.dirtiestcontext.dice_api.responses

import lombok.ToString

@ToString
class RollResponse {

	//Long instead of Integer because we are not sure how large the totals may get
	Long rollResponse

}
