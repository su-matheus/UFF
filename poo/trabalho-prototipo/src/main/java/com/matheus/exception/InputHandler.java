package com.matheus.exception;

import java.awt.TextField;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.validator.routines.EmailValidator;

public class InputHandler {
	public static boolean isEmailValid(String emailMessage) {
		EmailValidator validator = EmailValidator.getInstance();
		
		return validator.isValid(emailMessage);
	}
	
	public static boolean isUsernameValid(String username) {
		String usernameRegex = "^[a-zA-Z]{3,20}$";
		Pattern pattern = Pattern.compile(usernameRegex);
		Matcher matcher = pattern.matcher(username);
		return matcher.matches();
		
		//TextField usernameField = new TextField(username);
		//usernameField.setP
	}
}