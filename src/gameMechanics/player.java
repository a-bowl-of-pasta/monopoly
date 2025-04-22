package gameMechanics;

import java.io.Serializable;


public class player implements Serializable{

	String username; 
	private int money; 
	private int boardPosition; 
	private boolean eliminationStatus;
	
	// ================== constructor
	public player(String user, int startMoneyAmt)
	{
		username = user; 
		money = startMoneyAmt; 
		boardPosition = 0; 
		eliminationStatus = false; 
	}
	
	// ================ methods
	public void moveOnBoard(int moves, int sizeOfBoard)
	{
		// moves the player on the board
		boardPosition = (boardPosition +  moves) % sizeOfBoard; 
	}
	public void manipMoney(int money)
	{
		// adds or subtracts user money
		this.money += money; 
		
	}
	
	public void eliminate()
	{
		// eliminates player
		eliminationStatus = true; 
	}
	
	// =================== getters
	public int getMoney() {return money; }
	public String getUsername() {return username; }
	public int getBoardPostition() {return boardPosition;}
	public boolean isEliminated() {return eliminationStatus; }
	
	// ================= to string
	@Override
	public String toString() {
	    return username + " | $" + money + " | Pos: " + boardPosition + " | Eliminated: " + eliminationStatus;
	}
}
