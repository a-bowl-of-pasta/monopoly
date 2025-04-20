package clientBackend;

import java.io.IOException;

import gameMechanics.myAction;

public class clientMain {

	
	public static void testGameGUI()
	{
		new gui.gameGUI();
		System.out.println("finished running constructor call");
	}
	
	private static void autoConnectServer()
	{
	
	}
	
	private static void manualConnectServer()
	{
		 gameClient client = new gameClient("localhost", 8300);
	        try {
	            client.openConnection();

	            myAction action = new myAction(0, "ROLL");
	            client.sendToServer(action);

	        } catch (Exception e) {
	            System.out.println("Could not connect.");
	        }
	}
	
	public static void main(String[] args)
	{
	
		manualConnectServer(); 
		
		
	}
}