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

// udp broadcasting for autoConnect feature
class packageBroadcast extends Thread
{
	
	// variables 
	DatagramSocket socket; 
	int broadcastPort; 
	int serverPort; 
	String hostIPaddress; 
	boolean killBroadcast; 
	
	// overwritten run() from Thread
	public void run()
	{
		try 
		{
			// open new socket and enable broadcast
			socket = new DatagramSocket(); 
			socket.setBroadcast(true);
			
			// setup broadcast message and buffer
			String BroadcastMessage = "ServerInfo:"+ hostIPaddress +":" + serverPort ;
			byte[] buffer = BroadcastMessage.getBytes();
			
			// make packet with buffer / message, universal broadcast ip, and broadcast port
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("255.255.255.255"), broadcastPort);
			
			
			// starts broadcast until killBroadcast is called
			System.out.println("started broadcast");
			while(killBroadcast == false)
			{
				// send socket, print package sent, rest thread for 1 second
				socket.send(packet);
				System.out.println("packate sent :: " + BroadcastMessage);
				Thread.sleep(1000);

			}
			
			// broadcast ended, socket is closed
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
	public int getPort() {return serverPort;}
	public void killBroadcast() { killBroadcast = true; }
	
	// =========== constructor
	public packageBroadcast()
	{
		socket = null; 
		broadcastPort = 60123;
		serverPort = 8300; 
		killBroadcast = false; 
		
		// gets the local hosts ip address
		try {
			hostIPaddress = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}
	
}













