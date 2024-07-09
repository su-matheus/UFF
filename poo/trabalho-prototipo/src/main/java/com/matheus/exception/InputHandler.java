package com.matheus.exception;

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
	
	public static boolean isScoreValid(Integer score) {
		String scoreRegex = "\\d{1,2}";
		Pattern pattern = Pattern.compile(scoreRegex);
		Matcher matcher = pattern.matcher(score.toString());
		return matcher.matches();
	}
	
	public static boolean isPeriodValid(Integer period) {
		if (period > 2 || period < 1) {
			return false;
		}
		return false;
	}
}