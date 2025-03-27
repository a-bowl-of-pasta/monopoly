package gui;

import javax.swing.*; 
import java.awt.*; 
import javax.swing.border.*;

public class gameGUI extends JFrame {

	private JPanel mainPanel; 
	
	public gameGUI()
	{
		this.setTitle("board game");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(380, 380));
		this.setLayout(new BorderLayout());
		
		mainPanel = setMainPanel(); 
		
		setNorthPanel(); 
		setEastPanel();
		setSouthPanel(); 
		setWestPanel(); 
		
		this.add(mainPanel);
				
		this.setVisible(true); 
		this.pack(); 
		
	}
	
	// =========== creating the board's structure 
	private JPanel setMainPanel()
	{
		JPanel mainPan = new JPanel();
		
		mainPan.setLayout(new BorderLayout());
		
		return mainPan; 
	}
	
	private void setNorthPanel()
	{	
		JPanel northPan = new JPanel();
		northPan.setLayout(new GridLayout(0,11));
		
		createCell(northPan, 11);
		
		addToMainPanel(northPan, 'n');
	}
	
	private void setEastPanel()
	{
		JPanel eastPan = new JPanel();
		eastPan.setLayout(new GridLayout(9,0));
		
		createCell(eastPan, 9); 
		
		addToMainPanel(eastPan, 'e');
	}
	
	private void setSouthPanel()
	{
		JPanel southPan = new JPanel();
		southPan.setLayout(new GridLayout(0,11));
	
		
		createCell(southPan, 11);
	
		addToMainPanel(southPan, 's');
	}
	
	private void setWestPanel()
	{
		JPanel westPan = new JPanel(); 
		westPan.setLayout(new GridLayout(9,0));
		
		createCell(westPan, 9);
		
		addToMainPanel(westPan, 'w');
	}
	
	
	// ===== helper methods
	
	private void createCell(JPanel griddedPanel, int numOfCells)
	{
		for(int i = 0; i < numOfCells; i++)
		{
			
			JPanel cell = new JPanel(); 
			cell.setBorder(new LineBorder(Color.black, 2));
			
			griddedPanel.add(cell);
			griddedPanel.repaint();
			griddedPanel.revalidate();
		}
	}
	
	private void addToMainPanel(JPanel panelToAdd, char borderSide)
	{
		if(borderSide == 'n')
		{
			mainPanel.add(panelToAdd, BorderLayout.NORTH);
		}else if(borderSide == 's')
		{
			mainPanel.add(panelToAdd, BorderLayout.SOUTH);
		}else if(borderSide == 'e')
		{
			mainPanel.add(panelToAdd, BorderLayout.EAST);
		}else if(borderSide == 'w')
		{
			mainPanel.add(panelToAdd, BorderLayout.WEST);
		}
		
		mainPanel.revalidate();
		mainPanel.repaint();
	}
	
}
