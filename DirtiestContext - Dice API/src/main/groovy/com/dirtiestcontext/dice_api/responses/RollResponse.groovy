package com.dirtiestcontext.dice_api.responses

import lombok.ToString

@ToString
class RollResponse {

	Integer[] d2Results
	Integer d2Total
	Integer[] d4Results
	Integer d4Total
	Integer[] d5Results
	Integer d5Total
	Integer[] d6Results
	Integer d6Total
	Integer[] d8Results
	Integer d8Total
	Integer[] d10Results
	Integer d10Total
	Integer[] d12Results
	Integer d12Total
	Integer[] d20Results
	Integer d20Total
	Integer[] d100Results
	Integer d100Total
	Long rollTotal

}
