package serverBackend;

import java.io.*;
import java.net.*;
import java.util.*;

public class serverMain {
	
	serverMain(){}
	
	public static void testGameGUI()
	{
		new gui.gameGUI();
		System.out.println("finished running constructor call");
	}
	
	public static void cliStartServer(int port)
	{		 
		gameServer server = new gameServer(port);

        try {
            
        	server.listen();
            System.out.println("Server started on port : " + port);
            
        } catch (Exception e) {
            System.out.println("Failed to start server.");
        }
		
	}
	
	public static void main(String[] args)
	{
		//testGameGUI(); 
		
		packageBroadcast pb = new packageBroadcast(); 
		cliStartServer(pb.getPort());
		
		pb.run(); 
		
		pb.killBroadcast();	
        
        
	}
}

class packageBroadcast extends Thread
{
	
	DatagramSocket socket; 
	int broadcastPort; 
	String hostIPaddress; 
	boolean killBroadcast; 
	
	public void run()
	{
		try 
		{
			socket = new DatagramSocket(); 
			socket.setBroadcast(true);
			
			String BroadcastMessage = "ServerInfo:"+ hostIPaddress +":8300";
			byte[] buffer = BroadcastMessage.getBytes();
			
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("255.255.255.255"), broadcastPort);
			
			System.out.println("started broadcast");
			while(killBroadcast == false)
			{
				socket.send(packet);
				System.out.println("packate sent :: " + BroadcastMessage);
				Thread.sleep(1000);

			}
			System.out.println("ended broadcast");
			if (socket != null && socket.isClosed() != true)
			{
				socket.close();
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println("ERROR :: broadcast error :: ERROR");
			e.printStackTrace();
		}
	}
	// ================ helper methods
	public int getPort() {return broadcastPort;}
	public void killBroadcast()
	{
		killBroadcast = true; 
	}
	
	// =========== constructor
	public packageBroadcast()
	{
		socket = null; 
		broadcastPort = 60123;
		killBroadcast = false; 
		try {
			hostIPaddress = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}
	
}













