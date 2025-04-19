package serverBackend;

import ocsf.server.*;
import java.util.ArrayList;
import clientBackend.clientLogic;
import gameMechanics.gameLogic;
import gameMechanics.gameState;
import gameMechanics.myAction; 

public class serverLogic extends AbstractServer {

	private ArrayList<clientLogic> connectedPlayers; 
	private int maxPlayers; 
	private gameState currentState;
	private gameLogic gameActions; 
	
	// ========= adds a new client to the current players
	protected void addClient(clientLogic clientToAdd)
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

		
        // ------- sends player actions to game logic
	     if (message instanceof myAction) {
	            gameActions.performGameAction(message, client, currentState); 
	        } else {
	            System.out.println("Unknown message type.");
	        }
	}
	
	
	//======= constructors
	private void initializeAll()
	{		
		connectedPlayers = new ArrayList<clientLogic>(); 
		maxPlayers = 2; 
		currentState = new gameState(); 
	}
	serverLogic(int port) 
	{
		super(port);
		this.setTimeout(0);
		initializeAll(); 
	}
	serverLogic()
	{
		super(12345);
		this.setTimeout(0);
		initializeAll(); 
	}
	
	
	
	
}
