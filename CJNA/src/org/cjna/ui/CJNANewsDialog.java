package org.cjna.ui;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.HyperlinkEvent;
import javax.swing.JTextPane;

import org.cjna.parser.FeedMessage;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

import javax.swing.event.HyperlinkListener;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLFrameHyperlinkEvent;

/**
 * @author Pree Thiengburanathum preenet@gmail.com
 *
 */
public class CJNANewsDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
		private JTextPane textPane;
	
	/**
	 * Create the dialog.
	 */
	public CJNANewsDialog(final FeedMessage fm) {
		setBounds(100, 100, 450, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			 textPane = new JTextPane();
			 textPane.addMouseListener(new MouseAdapter() {  
				 Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
			       public void mouseEntered(MouseEvent me) {  
			    	   textPane.setCursor(handCursor);  
			        }  
			        public void mouseExited(MouseEvent me) {  
			        	textPane.setCursor(Cursor.getDefaultCursor());  
			        }  
			        public void mouseClicked(MouseEvent me)  {  
			        	 textPane.setCursor(handCursor);  
			           try {  
			        	   open(new URI("http://www.camt.cmu.ac.th/th"));
			             }  
			             catch(Exception e) {  
			                System.out.println(e);  
			             }  
			        }  
			 	@Override
			 	public void mousePressed(MouseEvent e) {
			 		textPane.setCursor(handCursor );  
			 	}
			 	@Override
			 	public void mouseReleased(MouseEvent e) {
			 		textPane.setCursor(handCursor );  
			 	}
			       });  
			
			textPane.setBackground(Color.LIGHT_GRAY);
			textPane.setContentType("text/html");
			textPane.setText(fm.toString());
			contentPanel.add(textPane, BorderLayout.CENTER);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
	 private static void open(URI uri) {
	        if (Desktop.isDesktopSupported()) {
	                Desktop desktop = Desktop.getDesktop();
	                try {
	                        desktop.browse(uri);
	                } catch (IOException e) {
	                        // TODO: error handling
	                }
	        } else {
	                // TODO: error handling
	        }
	 }
}// end class CJNANewsDialog
