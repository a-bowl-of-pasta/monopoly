package clientBackend;

import ocsf.client.*;
import java.io.IOException;
import gameMechanics.gameState;

public class gameClient extends AbstractClient {
	
	
	
		public boolean	checkServerConnection()
		{
			return super.isConnected();
		}
		
		
		// ============== required methods
	    @Override
	    protected void handleMessageFromServer(Object msg) {
	        
	    	if (msg instanceof gameState) 
	    	{
	            System.out.println("Client received updated GameState!");
	        } else {
	            System.out.println("Client received unknown message.");
	        }
	   
	    }
	    @Override
	    protected void connectionException(Exception e) {
	        System.out.println("Connection error.");
	    }
	    // ============== constructor
	    public gameClient(String host, int port) {
	        super(host, port);
	    }
}
