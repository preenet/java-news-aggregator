package org.cjna;

import java.util.Observable;

/**
 * @author Pree
 *
 */
public class SystemMessage extends Observable {
	  private String message;

	  public String getMessage() {
	    return message;
	  }

	  public void changeMessage(String message) {
	    this.message = message;
	    setChanged();
	    notifyObservers(message);
	  }
}// end class SystemMessage
