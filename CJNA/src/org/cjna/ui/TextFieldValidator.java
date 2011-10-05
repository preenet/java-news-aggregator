package org.cjna.ui;

import java.util.regex.Pattern;

/**
 * @author Pree Thiengburanathum preenet@gmail.com
 *
 */

public class TextFieldValidator {
	private Pattern p;
	public TextFieldValidator() {}
	
	/**
	 * 
	 * @param username
	 * @return
	 */
	public boolean checkUserName(String username) {
		if(username.isEmpty())
			return false;
	
		else if(username.matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+"))
			return false;
		else
			return true;
	}
	
	/**
	 * @param domain
	 * @return
	 */
	public boolean checkDomain(String domain) {
		if(domain.isEmpty())
			return false;
		else if(domain.matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+"))
			return false;
		else
			return true;
	}
	/**
	 * 
	 * @param password
	 * @return
	 */
	public boolean checkPassword(String password) {
		if(password.isEmpty())
			return false;
		return true;
	}

}// end TextFieldValidation
