package org.cjna.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;


public class CJNAListCellRenderer extends JLabel implements ListCellRenderer {
	/**
	 * @author Pree Thiengburanathum
	 * preenet@gmail.com
	 */
	private static final long serialVersionUID = 1L;
	
	public CJNAListCellRenderer() {
	         setOpaque(true);
	}

	public Component getListCellRendererComponent(JList list,
	                                                   Object value,
	                                                   int index,
	                                                   boolean isSelected,
	                                                   boolean cellHasFocus) {

			
			 String s = value.toString();
			 setFont(new Font("Lucida Sans",Font.PLAIN,12));
			 setText(s.trim());
			 
			 Color colr1 = new Color(139, 69, 19);
	    	 Color colr2 = new Color(255, 140, 0);

	         setBackground(isSelected ? colr2: colr1 );
	         setForeground(isSelected ? colr1 : colr2);
		     return this;
	}  
}// end class CJNAListCellRendere
