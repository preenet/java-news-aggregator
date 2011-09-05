package org.cjna.ui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class CJNAListCellRenderer extends JLabel implements ListCellRenderer {
	/**
	 * @author Pree
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
	    	 setText(value.toString());
	         setBackground(isSelected ? Color.red : Color.white);
	         setForeground(isSelected ? Color.white : Color.black);
	         return this;

	     }
}// end class CJNAListCellRendere
