package gameMechanics;

import java.io.Serializable;


public class player implements Serializable{

	String username; 
	private int money; 
	private int boardPosition; 
	private boolean stillInGame;
	
	public player(String user, int startMoneyAmt)
	{
		username = user; 
		money = startMoneyAmt; 
		boardPosition = 0; 
		stillInGame = true; 
	}
	public void moveOnBoard(int moves)
	{
		boardPosition += moves; 
	}
	public void manipMoney(int money)
	{
		money += money; 
	}
	
	
	
	
	
}
