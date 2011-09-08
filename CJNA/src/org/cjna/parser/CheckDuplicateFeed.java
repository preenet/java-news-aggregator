package org.cjna.parser;

import java.util.Vector;

/**
 * @author Pree Thiengburanathum preenet@gmail.com
 * 
 */
public class CheckDuplicateFeed {
	
	public CheckDuplicateFeed() {} // end constructor
	/**
	 * @param fmList
	 * @param fm
	 * @return boolean true of false
	 */
	public boolean isDuplicate(Vector<FeedMessage> fmList, FeedMessage fm) {
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

}// end class CheckDuplicateFeed
