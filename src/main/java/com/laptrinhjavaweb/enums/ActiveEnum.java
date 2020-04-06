package com.laptrinhjavaweb.enums;

public enum ActiveEnum {

	NAM("Nam"),
	NU("Nữ");
	private String value;
	private ActiveEnum(String value) {
		this.value=value;
	}
	public String getValue() {
		return value;
	}
}
