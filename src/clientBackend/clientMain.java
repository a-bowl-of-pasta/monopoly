package clientBackend;

import java.util.Scanner;

import gameMechanics.*;


public class clientMain {

	
	// ==================== run gui ===========
	public void autoConnectGUI()
	{
		
	}
	public void manualConnectGUI()
	{
		
	}
	
	public void loadGUI()
	{
		
	
		try 
		{
			autoConnectGUI(); 
			
		} catch(Exception e) 
		{
			manualConnectGUI(); 
			e.printStackTrace();
			
		}
	}

	// =============== run on console ==========
	private int mainMenu()
	{
		int choice; 
		String menue = """
				
				:: this is the main cli tester menu :: 
				
				1.) view player count
				2.) view server info
				3.) view player status
				4.) view game status
				5.) make move
				6.) disconnect server
			
				""";
		System.out.println(menue); 
		
		choice = (new Scanner(System.in)).nextInt(); 
		return choice; 
	}
	
	private void menuDriver(int choice, gameClient cso)
	{
		switch (choice){
			
			case 1:
				System.out.println("playerCount :: " ); 
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			default:
				System.out.println("invalidOption");
				break;
			}
	}
	
	public void cliSimulator(gameClient clientSideObj)
	{
			
		if(clientSideObj.checkServerConnection() == true)
		{	
			do 
			{
				int choice = mainMenu(); 
				menuDriver(choice, clientSideObj);
					
			}while(clientSideObj.checkServerConnection() == true);
		}
		else
		{
			System.out.println(":: ERROR connect to server ERROR ::");
		}
	}
	
	// ================= main client method ===========
	public static void main(String[] args)
	{
		clientMain newPlayer = new clientMain();
		
		gameClient joiningClient = new gameClient();
		newPlayer.cliSimulator(joiningClient);
		
	}
	
	// ============== constructor
	public clientMain() {}
}