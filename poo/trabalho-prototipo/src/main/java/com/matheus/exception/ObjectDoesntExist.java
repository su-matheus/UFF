package com.matheus.exception;

public class ObjectDoesntExist extends RuntimeException {
	public ObjectDoesntExist(String message) {
		super(message);
	}
}
