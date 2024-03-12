package com.dirtiestcontext.dice_api.enums

import com.dirtiestcontext.dice_api.exceptions.DieException
import groovy.util.logging.Slf4j

@Slf4j
enum Die {

	D2(2),
	D4(4),
	D5(5),
	D6(6),
	D8(8),
	D10(10),
	D12(12),
	D20(20),
	D100(100)

	Die(Integer numberOfSides) {
		this.numberOfSides = numberOfSides
	}

	final private Integer numberOfSides

	Integer numberOfSides() {
		return numberOfSides
	}

	//methods for working with Die

	Die returnEnum(Integer numberOfSides) {
		try {
			switch(numberOfSides) {
				case 2 : D2
					break
				case 4 : D4
					break
				case 5 : D5
					break
				case 6 : D6
					break
				case 8 : D8
					break
				case 10 : D10
					break
				case 12 : D12
					break
				case 20 : D20
					break
				case 100 : D100
					break
			}
		} finally {
			throw new DieException('That is not a value associated with a Die.')
		}
	}

	Integer returnNumberOfSides(Die die) {
		try {
			switch(die) {
				case D2 : 2
					break
				case D4 : 4
					break
				case D5 : 5
					break
				case D6 : 6
					break
				case D8 : 8
					break
				case D10 : 10
					break
				case D12 : 12
					break
				case D20 : 20
					break
				case D100 : 100
					break
			}
		} finally {
			throw new DieException('That is not a valid Die type.')
		}
	}
}