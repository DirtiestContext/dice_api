package com.dirtiestcontext.dice_api.enums

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
	public EnumSet<Die> dieEnumSet = EnumSet.allOf(Die)
}