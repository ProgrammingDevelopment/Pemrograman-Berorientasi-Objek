import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DoWhileGUI extends JFrame implements ActionListener {
    private JTextField textField;
    private JButton button;
    private JTextArea textArea;

    public DoWhileGUI() {
        setTitle("Do-While Loop");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Creating components
        textField = new JTextField(10);
        button = new JButton("Generate");
        textArea = new JTextArea(10, 20);
        textArea.setEditable(false);

        // Adding action listener to button
        button.addActionListener(this);

        // Creating panel and adding components
        JPanel panel = new JPanel();
        panel.add(new JLabel("Enter a number:"));
        panel.add(textField);
        panel.add(button);

        // Adding components to the frame
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(panel, BorderLayout.NORTH);
        container.add(new JScrollPane(textArea), BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            textArea.setText(""); // Clearing previous text
            try {
                int num = Integer.parseInt(textField.getText());
                int bil = 1;
                do {
                    textArea.append(bil + "\n");
                    ++bil;
                } while (bil <= num);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DoWhileGUI().setVisible(true);
        });
    }
}
