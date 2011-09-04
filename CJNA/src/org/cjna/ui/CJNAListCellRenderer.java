package org.cjna.ui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.ListCellRenderer;

public class CJNAListCellRenderer extends JLabel implements ListCellRenderer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Object value;
	  public CJNAListCellRenderer() {
	         setOpaque(true);
	     }

	     public Component getListCellRendererComponent(JList list,
	                                                   Object value,
	                                                   int index,
	                                                   boolean isSelected,
	                                                   boolean cellHasFocus) {
	    	 this.value = value;


	    	 setText(value.toString());

	         Color background;
	         Color foreground;

	         // check if this cell represents the current DnD drop location
	         JList.DropLocation dropLocation = list.getDropLocation();
	         if (dropLocation != null
	                 && !dropLocation.isInsert()
	                 && dropLocation.getIndex() == index) {

	             background = Color.BLUE;
	             foreground = Color.WHITE;

	         // check if this cell is selected
	         } else if (isSelected) {
	             background = Color.BLACK;
	             foreground = Color.YELLOW;

	         // unselected, and not the DnD drop location
	         } else {
	             background = Color.WHITE;
	             foreground = Color.BLACK;
	         };

	         setBackground(background);
	         setForeground(foreground);
	         return this;
	     }
}// end class CJNAListCellRendere
