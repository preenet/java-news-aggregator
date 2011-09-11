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
			 
			 Color colr1 = new Color(139, 69, 19);
	    	 Color colr2 = new Color(255, 140, 0);

	         setBackground(isSelected ? colr2: colr1 );
	         setForeground(isSelected ? colr1 : colr2);
	         try {
				loadFont();
			} catch (FontFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     return this;
	}  
	

	  public void loadFont() throws FontFormatException, IOException{
	    String fontFileName = "Lucida Sans Unicode.ttf";
	   File f = new File(fontFileName);
	   FileInputStream in = new FileInputStream(f);

	    Font ttfBase = Font.createFont(Font.TRUETYPE_FONT, in);

	    Font ttfReal = ttfBase.deriveFont(Font.PLAIN, 24);
	    
	  }
}// end class CJNAListCellRendere
