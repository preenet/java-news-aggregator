package org.cjna.net;

/**
 * @author Pree Thiengburanathum preenet@gmail.com
 * 
 */
public class PortValidator {

	public PortValidator() {

	}

	/**
	 * @param port
	 * @return
	 */
	public boolean validate(String port) {
		// check the port is empty
		if (port.isEmpty())
			return false;

		else {

			// check if string is digit
			try {
				Integer.parseInt(port);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}// end method validate
}// end class PortValidator
