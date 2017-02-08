package com.app.utils;

public enum NotificationMessages {

	STUDENT_SAVE_VALIDATION_ERROR_TITLE("ERROR"),
	STUDENT_SAVE_VALIDATION_ERROR_DESCRIPTION("Fields must filled"),
	STUDENT_SAVE_SUCCESS_TITLE("Save"),
	STUDENT_SAVE_SUCCESS_DESCRIPTION("Student has been saved!")
	;
	
	private final String string;
	
	private NotificationMessages(String string) {
		this.string = string;
	}
	
	public String getString() {
		return this.string;
	}
}
