import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicketForm extends JDialog {
    private JTextField artistField;
    private JTextField dateField;
    private JTextField priceField;
    private JTextField quantityField;
    private JButton saveButton;
    private JButton cancelButton;
    private Ticket ticket;

    public TicketForm(Frame parent, String title, Ticket ticket) {
        super(parent, title, true);
        this.ticket = ticket;

        JPanel panel = new JPanel(new GridLayout(5, 2));
        getContentPane().add(panel, BorderLayout.CENTER);

        panel.add(new JLabel("Artist:"));
        artistField = new JTextField();
        panel.add(artistField);

        panel.add(new JLabel("Date:"));
        dateField = new JTextField();
        panel.add(dateField);

        panel.add(new JLabel("Price:"));
        priceField = new JTextField();
        panel.add(priceField);

        panel.add(new JLabel("Quantity:"));
        quantityField = new JTextField();
        panel.add(quantityField);

        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);

        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        if (ticket != null) {
            artistField.setText(ticket.getArtist());
            dateField.setText(ticket.getDate());
            priceField.setText(String.valueOf(ticket.getPrice()));
            quantityField.setText(String.valueOf(ticket.getQuantity()));
        }

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveTicket();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setSize(300, 200);
        setLocationRelativeTo(parent);
    }

    private void saveTicket() {
        String artist = artistField.getText();
        String date = dateField.getText();
        int price;
        int quantity;

        try {
            price = Integer.parseInt(priceField.getText());
            quantity = Integer.parseInt(quantityField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for price and quantity.");
            return;
        }

        if (ticket == null) {
            ticket = new Ticket();
            ticket.setArtist(artist);
            ticket.setDate(date);
            ticket.setPrice(price);
            ticket.setQuantity(quantity);
            TicketController.createTicket(ticket);
        } else {
            ticket.setArtist(artist);
            ticket.setDate(date);
            ticket.setPrice(price);
            ticket.setQuantity(quantity);
            TicketController.updateTicket(ticket);
        }

        setVisible(false);
    }
}
