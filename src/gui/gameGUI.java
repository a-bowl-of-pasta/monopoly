package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gameGUI extends JFrame {
    private JPanel mainPanel;
    private static final Color BOARD_COLOR = new Color(204, 232, 218);
    private static final int TILE_SIZE = 80;

    private JPanel[] allTiles = new JPanel[40];
    private JLabel[] playerIcons = new JLabel[2];
    private int[] playerPositions = new int[] {0, 0};

    private JLabel rollResultLabel;

    private static final String[] TILE_TEXTS = {
        "GO\nCollect $200", "Mediterranean Avenue\n$60", "COMMUNITY CHEST", "Baltic Avenue\n$60", "Income Tax\nPay $200",
        "Reading Railroad\n$200", "Oriental Avenue\n$100", "CHANCE", "Vermont Avenue\n$100", "Connecticut Avenue\n$120",
        "JAIL / Just Visiting",
        "St. Charles Place\n$140", "Electric Company\n$150", "States Avenue\n$140", "Virginia Avenue\n$160",
        "COMMUNITY CHEST", "St. James Place\n$180", "Pennsylvania Railroad\n$200", "Tennessee Avenue\n$180", "New York Avenue\n$200",
        "Free Parking",
        "Kentucky Avenue\n$220", "CHANCE", "Indiana Avenue\n$220", "Illinois Avenue\n$240",
        "B&O Railroad\n$200", "Atlantic Avenue\n$260", "Ventnor Avenue\n$260", "Water Works\n$150", "Marvin Gardens\n$280",
        "Go To Jail",
        "Pacific Avenue\n$300", "North Carolina Avenue\n$300", "COMMUNITY CHEST", "Pennsylvania Avenue\n$320",
        "Short Line Railroad\n$200", "CHANCE", "Park Place\n$350", "Luxury Tax\nPay $75", "Boardwalk\n$400"
    };

    private static final Color[] STRIPE_COLORS = {
        null, new Color(106, 90, 205), null, new Color(106, 90, 205), null,
        null, new Color(173, 216, 230), null, new Color(173, 216, 230), new Color(173, 216, 230),
        null,
        new Color(255, 192, 203), null, new Color(255, 192, 203), new Color(255, 192, 203),
        null, new Color(255, 165, 0), null, new Color(255, 165, 0), new Color(255, 165, 0),
        null,
        new Color(255, 0, 0), null, new Color(255, 0, 0), new Color(255, 0, 0),
        null, new Color(255, 255, 0), new Color(255, 255, 0), null, new Color(255, 255, 0),
        null,
        new Color(0, 128, 0), new Color(0, 128, 0), null, new Color(0, 128, 0),
        null, null, new Color(0, 0, 139), null, new Color(0, 0, 139)
    };

    public gameGUI() {
        this.setTitle("Monopoly");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(880,880);
        this.setMinimumSize(new Dimension(880, 880));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(BOARD_COLOR);
        setSouthPanel();
        setWestPanel();
        setNorthPanel();
        setEastPanel();
        setCenterPanel();

        this.add(mainPanel);
        this.setVisible(true);
        this.pack();

        initPlayerIcons();
    }

    private void setSouthPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 11));
        panel.setBackground(BOARD_COLOR);
        for (int i = 0; i < 11; i++) {
            int trueIndex = 10 - i;
            panel.add(allTiles[trueIndex] = createLabeledTile(TILE_TEXTS[trueIndex], STRIPE_COLORS[trueIndex]));
        }
        panel.setPreferredSize(new Dimension(11 * TILE_SIZE, TILE_SIZE));
        mainPanel.add(panel, BorderLayout.SOUTH);
    }

    private void setWestPanel() {
        JPanel panel = new JPanel(new GridLayout(9, 1));
        panel.setBackground(BOARD_COLOR);
        for (int i = 0; i < 9; i++) {
            int trueIndex = 19 - i;
            panel.add(allTiles[trueIndex] = createLabeledTile(TILE_TEXTS[trueIndex], STRIPE_COLORS[trueIndex]));
        }
        panel.setPreferredSize(new Dimension(TILE_SIZE, 9 * TILE_SIZE));
        mainPanel.add(panel, BorderLayout.WEST);
    }

    private void setNorthPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 11));
        panel.setBackground(BOARD_COLOR);
        for (int i = 0; i < 11; i++) {
            int trueIndex = 20 + i;
            panel.add(allTiles[trueIndex] = createLabeledTile(TILE_TEXTS[trueIndex], STRIPE_COLORS[trueIndex]));
        }
        panel.setPreferredSize(new Dimension(11 * TILE_SIZE, TILE_SIZE));
        mainPanel.add(panel, BorderLayout.NORTH);
    }

    private void setEastPanel() {
        JPanel panel = new JPanel(new GridLayout(9, 1));
        panel.setBackground(BOARD_COLOR);
        for (int i = 0; i < 9; i++) {
            int trueIndex = 31 + i;
            panel.add(allTiles[trueIndex] = createLabeledTile(TILE_TEXTS[trueIndex], STRIPE_COLORS[trueIndex]));
        }
        panel.setPreferredSize(new Dimension(TILE_SIZE, 9 * TILE_SIZE));
        mainPanel.add(panel, BorderLayout.EAST);
    }

    private void setCenterPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(BOARD_COLOR);
        panel.setPreferredSize(new Dimension(7 * TILE_SIZE, 7 * TILE_SIZE));

        JLabel label = new JLabel("MONOPOLY", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 48));
        label.setForeground(Color.RED);
        panel.add(label, BorderLayout.NORTH);

        JButton rollButton = new JButton("Roll Dice");
        rollButton.setFont(new Font("Arial", Font.BOLD, 16));

        rollResultLabel = new JLabel("Roll: -", SwingConstants.CENTER);
        rollResultLabel.setFont(new Font("Arial", Font.BOLD, 16));

        rollButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int roll = (int)(Math.random() * 6 + 1);
                rollResultLabel.setText("Roll: " + roll);

                int newPosition = (playerPositions[0] + roll) % 40;
                updatePlayerPosition(0, newPosition); // Only move red circle (Player 1)
            }
        });

        JPanel dicePanel = new JPanel();
        dicePanel.setLayout(new BoxLayout(dicePanel, BoxLayout.Y_AXIS));
        dicePanel.setOpaque(false);
        dicePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        rollButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        rollResultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        dicePanel.add(rollButton);
        dicePanel.add(Box.createVerticalStrut(10));
        dicePanel.add(rollResultLabel);

        JPanel bottomWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomWrapper.setOpaque(false);
        bottomWrapper.add(dicePanel);
        panel.add(bottomWrapper, BorderLayout.SOUTH);

        mainPanel.add(panel, BorderLayout.CENTER);
    }

    private JPanel createLabeledTile(String name, Color stripeColor) {
        JPanel tile = new JPanel();
        tile.setLayout(null);
        tile.setPreferredSize(new Dimension(TILE_SIZE, TILE_SIZE));
        tile.setBackground(BOARD_COLOR);
        tile.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        if (stripeColor != null) {
            JPanel stripe = new JPanel();
            stripe.setBounds(0, 0, TILE_SIZE, 16);
            stripe.setBackground(stripeColor);
            tile.add(stripe);
        }

        JLabel label = new JLabel("<html><center>" + name.replace("\n", "<br>") + "</center></html>", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 10));
        label.setBounds(2, 18, TILE_SIZE - 4, TILE_SIZE - 20);
        tile.add(label);

        return tile;
    }

    private void initPlayerIcons() {
        String[] symbols = {"●", "▲"};
        Color[] colors = {Color.RED, Color.BLUE};
        Point[] positions = { new Point(5, 5), new Point(40, 40) };

        for (int i = 0; i < 2; i++) {
            JLabel label = new JLabel(symbols[i]);
            label.setFont(new Font("SansSerif", Font.BOLD, 22));
            label.setForeground(colors[i]);
            label.setBounds(positions[i].x, positions[i].y, 30, 30);
            playerIcons[i] = label;
            allTiles[0].add(label);
        }

        allTiles[0].revalidate();
        allTiles[0].repaint();
    }

    public void updatePlayerPosition(int playerId, int newTileIndex) {
        JPanel oldTile = allTiles[playerPositions[playerId]];
        JPanel newTile = allTiles[newTileIndex];

        oldTile.remove(playerIcons[playerId]);
        oldTile.revalidate();
        oldTile.repaint();

        newTile.setLayout(null);
        JLabel icon = playerIcons[playerId];
        icon.setBounds(playerId == 0 ? 5 : 40, playerId == 0 ? 5 : 40, 30, 30);
        newTile.add(icon);
        newTile.revalidate();
        newTile.repaint();

        playerPositions[playerId] = newTileIndex;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new gameGUI());
    }
}