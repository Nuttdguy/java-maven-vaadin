package com.app.utils;

public enum Gender {
	
	MALE("Male"),
	FEMALE("Female")
	;
	
	private String string;
	
	Gender(String string) {
		this.string = string;
	}

	public String getString() {
		return this.string;
	}
	
}
