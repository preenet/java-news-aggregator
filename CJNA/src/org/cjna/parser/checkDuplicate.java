package org.cjna.parser;

import java.util.ArrayList;

/**
 * @author Pree
 *
 */
public class checkDuplicate {
	
	public checkDuplicate() {} // end constructor
	/**
	 * @param fmList
	 * @param fm
	 * @return 
	 */
	public boolean isDuplicate(ArrayList<FeedMessage> fmList, FeedMessage fm) {
		// iterate through the array list and check from the title if the string is match the coming fm.
		// if match, we then remove from the array list.
		
		for(int i = 0; i < fmList.size(); i ++) {
			if(fmList.get(i).getTitle().equals(fm.getTitle()) &&
					fmList.get(i).getDescription().equals(fm.getDescription())) {
				return true;
			}
		}
		return false;
	}

}// end class checkDuplicaet
