package org.cjna.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import org.omg.CORBA.portable.InputStream;


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
			 setText(s.trim());
			 
			 Color colr2 = new Color(248,179, 16);
	    	 Color colr1 = new Color(84, 36, 0);

	         setBackground(isSelected ? colr2: colr1 );
	         setForeground(isSelected ? colr1 : colr2);
	         setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		     return this;
	}  
}// end class CJNAListCellRendere
