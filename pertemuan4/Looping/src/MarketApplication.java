import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Market class representing the market for jersey cloth
class Market {
    private String marketName;

    public Market(String name) {
        marketName = name;
    }

    public String getMarketName() {
        return marketName;
    }

    // Method to sell jersey cloth
    public void sellJerseyCloth(int quantity) {
        System.out.println("Sold " + quantity + " jersey cloths at " + marketName);
    }
}

// GUI class for the market application
public class MarketApplication extends JFrame implements ActionListener {
    private JComboBox<String> loopTypeComboBox;
    private JTextField quantityField;
    private JTextArea outputArea;
    private JButton sellButton;

    public MarketApplication() {
        setTitle("Market Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Creating components
        loopTypeComboBox = new JComboBox<>(new String[]{"for", "while", "do-while"});
        quantityField = new JTextField(10);
        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);
        sellButton = new JButton("Sell");

        // Adding action listener to the button
        sellButton.addActionListener(this);

        // Creating panel and adding components
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(new JLabel("Loop Type:"));
        panel.add(loopTypeComboBox);
        panel.add(new JLabel("Quantity:"));
        panel.add(quantityField);
        panel.add(sellButton);

        // Adding components to the frame
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(panel, BorderLayout.NORTH);
        container.add(new JScrollPane(outputArea), BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sellButton) {
            String loopType = (String) loopTypeComboBox.getSelectedItem();
            int quantity = Integer.parseInt(quantityField.getText());

            Market market = new Market("Jersey Cloth Market");
            outputArea.setText(""); // Clearing previous output

            switch (loopType) {
                case "for":
                    for (int i = 0; i < quantity; i++) {
                        market.sellJerseyCloth(quantity);
                    }
                    break;
                case "while":
                    int whileCounter = 0;
                    while (whileCounter < quantity) {
                        market.sellJerseyCloth(quantity);
                        whileCounter++;
                    }
                    break;
                case "do-while":
                    int doWhileCounter = 0;
                    do {
                        market.sellJerseyCloth(quantity);
                        doWhileCounter++;
                    } while (doWhileCounter < quantity);
                    break;
                default:
                    outputArea.setText("Invalid loop type selected.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MarketApplication().setVisible(true);
        });
    }
}
