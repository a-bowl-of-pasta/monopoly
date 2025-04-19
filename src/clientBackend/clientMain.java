package clientBackend;

import java.io.IOException;

public class clientMain {

	
	public static void testGameGUI()
	{
		new gui.gameGUI();
		System.out.println("finished running constructor call");
	}
	
	private void autoConnectServer()
	{
	
	}
	
	private void manualConnectServer()
	{
		
	}
	
	public static void main(String[] args)
	{
		
		clientMain clientMain = new clientMain();
		try 
		{
			clientMain.autoConnectServer();
		
		}catch (IOException e )
		{
			
			e.printStackTrace();
			clientMain.manualConnectServer();
		}
		
		
	}
}