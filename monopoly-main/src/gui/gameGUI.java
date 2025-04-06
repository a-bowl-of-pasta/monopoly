package gui;

import javax.swing.*; 
import java.awt.*; 
import javax.swing.border.*;

public class gameGUI extends JFrame {

    private JPanel mainPanel; 
    private static final Color BOARD_COLOR = new Color(204, 232, 218);
    private static final int TILE_WIDTH = 72;
    private static final int TILE_HEIGHT = 90;
    private static final int CORNER_TILE_SIZE = 90;

    public gameGUI() {
        this.setTitle("board game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(850, 850);
        this.setMinimumSize(new Dimension(850, 850));
        this.setLayout(new BorderLayout());

        mainPanel = setMainPanel(); 

        setNorthPanel(); 
        setEastPanel();
        setSouthPanel(); 
        setWestPanel(); 
        setCenterPanel();

        this.add(mainPanel);
        this.setVisible(true); 
        this.pack(); 
    }

    private JPanel setMainPanel() {
        JPanel mainPan = new JPanel(new BorderLayout());
        mainPan.setBackground(BOARD_COLOR);
        return mainPan; 
    }

    private void setSouthPanel() {
        JPanel southPan = new JPanel(new GridLayout(1, 11, 1, 1));
        southPan.setBackground(BOARD_COLOR);

        southPan.add(createImageCell("pictures/MonopolyTilesDone/jail.PNG", CORNER_TILE_SIZE, CORNER_TILE_SIZE));
        southPan.add(createLabeledTile("Connecticut Avenue\n$120", new Color(173, 216, 230)));
        southPan.add(createLabeledTile("Vermont Avenue\n$100", new Color(173, 216, 230)));
        southPan.add(createLabeledTile("CHANCE\n?", BOARD_COLOR));
        southPan.add(createLabeledTile("Oriental Avenue\n$100", new Color(173, 216, 230)));
        southPan.add(createLabeledTile("<b>Reading Railroad</b>\n$200", null));
        southPan.add(createLabeledTile("Income Tax\nPay 10% or $200", BOARD_COLOR));
        southPan.add(createLabeledTile("Baltic Avenue\n$60", new Color(106, 90, 205)));
        southPan.add(createLabeledTile("<b>COMMUNITY\nCHEST</b>", BOARD_COLOR));
        southPan.add(createLabeledTile("Mediterranean Avenue\n$60", new Color(106, 90, 205)));
        southPan.add(createImageCell("pictures/MonopolyTilesDone/gocorner.PNG", CORNER_TILE_SIZE, CORNER_TILE_SIZE));

        southPan.setPreferredSize(new Dimension(800, CORNER_TILE_SIZE));
        addToMainPanel(southPan, 's');
    }

    private void setWestPanel() {
        JPanel westPan = new JPanel(new GridLayout(9, 1, 1, 1));
        westPan.setBackground(BOARD_COLOR);

        westPan.add(createLabeledTile("New York Avenue\n$200", new Color(255, 165, 0)));
        westPan.add(createLabeledTile("Tennessee Avenue\n$180", new Color(255, 165, 0)));
        westPan.add(createLabeledTile("<b>Pennsylvania Railroad</b>\n$200", null));
        westPan.add(createLabeledTile("St. James Place\n$180", new Color(255, 165, 0)));
        westPan.add(createLabeledTile("<b>COMMUNITY\nCHEST</b>", BOARD_COLOR));
        westPan.add(createLabeledTile("Virginia Avenue\n$160", new Color(255, 192, 203)));
        westPan.add(createLabeledTile("States Avenue\n$140", new Color(255, 192, 203)));
        westPan.add(createLabeledTile("<b>Electric Company</b>\n$150", null));
        westPan.add(createLabeledTile("St. Charles Place\n$140", new Color(255, 192, 203)));

        westPan.setPreferredSize(new Dimension(CORNER_TILE_SIZE, 800));
        addToMainPanel(westPan, 'w');
    }

    private void setNorthPanel() {
        JPanel northPan = new JPanel(new GridLayout(1, 11, 1, 1));
        northPan.setBackground(BOARD_COLOR);

        northPan.add(createImageCell("pictures/MonopolyTilesDone/freeparking.PNG", CORNER_TILE_SIZE, CORNER_TILE_SIZE));
        northPan.add(createLabeledTile("Kentucky Avenue\n$220", new Color(255, 0, 0)));
        northPan.add(createLabeledTile("CHANCE\n?", BOARD_COLOR));
        northPan.add(createLabeledTile("Indiana Avenue\n$220", new Color(255, 0, 0)));
        northPan.add(createLabeledTile("Illinois Avenue\n$240", new Color(255, 0, 0)));
        northPan.add(createLabeledTile("<b>B&O Railroad</b>\n$200", null));
        northPan.add(createLabeledTile("Atlantic Avenue\n$260", new Color(255, 255, 0)));
        northPan.add(createLabeledTile("Ventnor Avenue\n$260", new Color(255, 255, 0)));
        northPan.add(createLabeledTile("Marvin Gardens\n$280", new Color(255, 255, 0)));
        northPan.add(createLabeledTile("Illinois Avenue\n$240", new Color(255, 0, 0)));
        northPan.add(createImageCell("pictures/MonopolyTilesDone/gotojail.PNG", CORNER_TILE_SIZE, CORNER_TILE_SIZE));

        northPan.setPreferredSize(new Dimension(800, CORNER_TILE_SIZE));
        addToMainPanel(northPan, 'n');
    }

    private void setEastPanel() {
        JPanel eastPan = new JPanel(new GridLayout(9, 1, 1, 1));
        eastPan.setBackground(BOARD_COLOR);

        eastPan.add(createLabeledTile("Pacific Avenue\n$300", new Color(0, 128, 0)));
        eastPan.add(createLabeledTile("North Carolina Avenue\n$300", new Color(0, 128, 0)));
        eastPan.add(createLabeledTile("<b>COMMUNITY\nCHEST</b>", BOARD_COLOR));
        eastPan.add(createLabeledTile("Pennsylvania Avenue\n$320", new Color(0, 128, 0)));
        eastPan.add(createLabeledTile("<b>Short Line Railroad</b>\n$200", null));
        eastPan.add(createLabeledTile("CHANCE\n?", BOARD_COLOR));
        eastPan.add(createLabeledTile("Park Place\n$350", new Color(0, 0, 139)));
        eastPan.add(createLabeledTile("Luxury Tax\nPay $75", BOARD_COLOR));
        eastPan.add(createLabeledTile("Boardwalk\n$400", new Color(0, 0, 139)));

        eastPan.setPreferredSize(new Dimension(CORNER_TILE_SIZE, 800));
        addToMainPanel(eastPan, 'e');
    }

    private void setCenterPanel() {
        JPanel centerPan = new JPanel(new GridBagLayout());
        centerPan.setBackground(BOARD_COLOR);

        JLabel logo = new JLabel("MONOPOLY");
        logo.setFont(new Font("Arial", Font.BOLD, 48));
        logo.setForeground(Color.RED);
        centerPan.add(logo);

        addToMainPanel(centerPan, 'c');
    }

    private JPanel createImageCell(String resourcePath, int width, int height) {
        JPanel cell = new JPanel();
        cell.setPreferredSize(new Dimension(width, height));
        cell.setLayout(new GridBagLayout());
        cell.setBackground(BOARD_COLOR);
        cell.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        java.net.URL imageURL = getClass().getClassLoader().getResource(resourcePath);
        if (imageURL == null) {
            System.out.println("❌ Image not found: " + resourcePath);
            return cell;
        }

        ImageIcon icon = new ImageIcon(imageURL);
        Image image = icon.getImage();
        int originalWidth = icon.getIconWidth();
        int originalHeight = icon.getIconHeight();
        double widthRatio = (double) width / originalWidth;
        double heightRatio = (double) height / originalHeight;
        double scale = Math.min(widthRatio, heightRatio);

        int scaledWidth = (int) (originalWidth * scale);
        int scaledHeight = (int) (originalHeight * scale);

        Image scaledImage = image.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
        JLabel label = new JLabel(new ImageIcon(scaledImage));
        cell.add(label);

        return cell;
    }

    private JPanel createLabeledTile(String name, Color stripeColor) {
        JPanel tile = new JPanel();
        tile.setPreferredSize(new Dimension(TILE_WIDTH, TILE_HEIGHT));
        tile.setLayout(new BorderLayout());
        tile.setBackground(BOARD_COLOR);
        tile.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        if (stripeColor != null && !stripeColor.equals(Color.WHITE)) {
            JPanel stripe = new JPanel();
            stripe.setPreferredSize(new Dimension(TILE_WIDTH, 20));
            stripe.setBackground(stripeColor);
            tile.add(stripe, BorderLayout.NORTH);
        }

        JLabel label = new JLabel("<html><center>" + name.replace("\n", "<br>") + "</center></html>", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, name.contains("?") ? 16 : 10));
        tile.add(label, BorderLayout.CENTER);

        return tile;
    }

    private void createCell(JPanel griddedPanel, int numOfCells) {
        for (int i = 0; i < numOfCells; i++) {
            JPanel cell = new JPanel();
            cell.setBackground(BOARD_COLOR);
            cell.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            cell.setPreferredSize(new Dimension(TILE_WIDTH, TILE_HEIGHT));
            griddedPanel.add(cell);
        }
    }

    private void addToMainPanel(JPanel panelToAdd, char borderSide) {
        if (borderSide == 'n') {
            mainPanel.add(panelToAdd, BorderLayout.NORTH);
        } else if (borderSide == 's') {
            mainPanel.add(panelToAdd, BorderLayout.SOUTH);
        } else if (borderSide == 'e') {
            mainPanel.add(panelToAdd, BorderLayout.EAST);
        } else if (borderSide == 'w') {
            mainPanel.add(panelToAdd, BorderLayout.WEST);
        } else if (borderSide == 'c') {
            mainPanel.add(panelToAdd, BorderLayout.CENTER);
        }
        mainPanel.revalidate();
        mainPanel.repaint();
    }
}
