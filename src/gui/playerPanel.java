package gui;


import javax.swing.*;
import java.awt.*;
import java.util.List;

public class playerPanel extends JPanel {



	private static final long serialVersionUID = 1L;
	private JLabel usernameLabel;
    private JLabel moneyLabel;
    private JTextArea propertiesArea;
    private JTextArea validMovesArea;

    private JButton endTurnButton;
    private JButton buyButton;
    private JButton sellButton;

    public playerPanel(String username, int money, List<String> properties, List<String> validMoves) {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createTitledBorder("Player Info"));
        System.out.println("Launching playerPanel window...");

        // Top: Player Name + Money
        JPanel topPanel = new JPanel(new GridLayout(2, 1));
        usernameLabel = new JLabel("Username: " + username);
        moneyLabel = new JLabel("Money: $" + money);
        topPanel.add(usernameLabel);
        topPanel.add(moneyLabel);

        // Center: Properties and Valid Moves
        JPanel centerPanel = new JPanel(new GridLayout(2, 1, 5, 5));

        propertiesArea = new JTextArea(5, 20);
        propertiesArea.setEditable(false);
        for (String prop : properties) {
            propertiesArea.append("- " + prop + "\n");
        }
        centerPanel.add(createLabeledPanel("Properties Owned", propertiesArea));

        validMovesArea = new JTextArea(5, 20);
        validMovesArea.setEditable(false);
        for (String move : validMoves) {
            validMovesArea.append("> " + move + "\n");
        }
        centerPanel.add(createLabeledPanel("Valid Moves", validMovesArea));

        // Bottom: Action Buttons
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        endTurnButton = new JButton("End Turn");
        buyButton = new JButton("Buy Property");
        sellButton = new JButton("Sell Property");

        buttonPanel.add(buyButton);
        buttonPanel.add(sellButton);
        buttonPanel.add(endTurnButton);

        // Compose layout
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private JPanel createLabeledPanel(String title, JTextArea area) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(title));
        panel.add(new JScrollPane(area), BorderLayout.CENTER);
        return panel;
    }

    // Optionally expose buttons for listeners
    public JButton getEndTurnButton() { return endTurnButton; }
    public JButton getBuyButton() { return buyButton; }
    public JButton getSellButton() { return sellButton; }

    // Update methods
    public void updateMoney(int newMoney) {
        moneyLabel.setText("Money: $" + newMoney);
    }

    public void updateProperties(List<String> props) {
        propertiesArea.setText("");
        for (String p : props) {
            propertiesArea.append("- " + p + "\n");
        }
    }

    public void updateMoves(List<String> moves) {
        validMovesArea.setText("");
        for (String m : moves) {
            validMovesArea.append("> " + m + "\n");
        }
    }
}

