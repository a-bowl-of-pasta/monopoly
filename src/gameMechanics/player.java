package gameMechanics;

import java.io.Serializable;


public class player implements Serializable{

	String username; 
	private int money; 
	private int boardPosition; 
	private boolean eliminationStatus;
	
	public player(String user, int startMoneyAmt)
	{
		username = user; 
		money = startMoneyAmt; 
		boardPosition = 0; 
		eliminationStatus = false; 
	}
	public void moveOnBoard(int moves, int sizeOfBoard)
	{
		boardPosition = (boardPosition +  moves) % sizeOfBoard; 
	}
	public void manipMoney(int money)
	{
		this.money += money; 
		
	}
	
	public void eliminate()
	{
		eliminationStatus = true; 
	}
	public int getMoney() {return money; }
	public String getUsername() {return username; }
	public int getBoardPostition() {return boardPosition;}
	public boolean isEliminated() {return eliminationStatus; }
	
	@Override
	public String toString() {
	    return username + " | $" + money + " | Pos: " + boardPosition + " | Eliminated: " + eliminationStatus;
	}
}
