package serverBackend;

public class serverMain {

	
	public static void testGameGUI()
	{
		new gui.gameGUI();
		System.out.println("finished running constructor call");
	}
	
	public static void testLoginGUI()
	{
		
	}
	
	public static void main(String[] args)
	{
		testGameGUI(); 
		
	    gameServer server = new gameServer(8300);
        try {
            server.listen();
            System.out.println("Server started on port 8300.");
        } catch (Exception e) {
            System.out.println("Failed to start server.");
        }
        
        
	}
}
