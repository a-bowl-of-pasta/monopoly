package serverBackend;

import ocsf.server.*;

import java.io.IOException;
import java.util.ArrayList;
import clientBackend.gameClient;
import gameMechanics.gameLogic;
import gameMechanics.gameState;
import gameMechanics.myAction; 

public class gameServer extends AbstractServer {

	private ArrayList<gameClient> connectedPlayers; 
	private int maxPlayers; 
	private gameState currentState;
	private gameLogic gameActions; 
	
	// ========= adds a new client to the current players
	protected void addClient(gameClient clientToAdd)
	{
		System.out.println("new player joining");
		
		connectedPlayers.add(clientToAdd);
		
		// -------- starts the game when max players are in
		if(connectedPlayers.size() == maxPlayers)
		{
			System.out.println("all players have joined, startting game");
			
		}
	}
	
	
	// ============= does the game logic
	@Override
	protected void handleMessageFromClient(Object message, ConnectionToClient client) {
		// TODO Auto-generated method stub
        System.out.println("Received from client: " + message);

		
        // ------- sends player actions to game logic i
        
        try {
        	if (message instanceof myAction) {
	    	 
	   	 		gameState state = new gameState();  	
				client.sendToClient(state);
			
	         //   gameActions.performGameAction(message, client, currentState); 
	     	} else {
	           	System.out.println("Unknown message type.");
	        }
	        
	    
        } catch (IOException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//======= constructors
	private void initializeAll()
	{		
		connectedPlayers = new ArrayList<gameClient>(); 
		maxPlayers = 2; 
		currentState = new gameState(); 
	}
	gameServer(int port) 
	{
		super(port);
		this.setTimeout(0);
		initializeAll(); 
	}
	gameServer()
	{
		super(12345);
		this.setTimeout(0);
		initializeAll(); 
	}
	
	
	
	
}
