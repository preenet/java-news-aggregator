package cjna.net;

public class PortValidator {
	
		public PortValidator () {
			
		}
		
		public boolean validate(String port) {
			try { 
				Integer.parseInt(port);  
			  return true;  
			}catch( Exception e)  
			   {  
			      return false;  
			   }  
		}		 
}// end class PortValidator
