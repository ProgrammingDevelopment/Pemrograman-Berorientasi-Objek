import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class GUI extends JFrame {
    private JTable table;
    private TicketTableModel tableModel;

    public GUI() {
        setTitle("Concert Ticketing System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        tableModel = new TicketTableModel();
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add");
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TicketForm form = new TicketForm(GUI.this, "Add Ticket", null);
                form.setVisible(true);
                refreshTable();
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    int id = (int) tableModel.getValueAt(selectedRow, 0);
                    Ticket ticket = tableModel.getTicketById(id);
                    TicketForm form = new TicketForm(GUI.this, "Edit Ticket", ticket);
                    form.setVisible(true);
                    refreshTable();
                } else {
                    JOptionPane.showMessageDialog(GUI.this, "Please select a ticket to edit.");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    int id = (int) tableModel.getValueAt(selectedRow, 0);
                    TicketController.deleteTicket(id);
                    refreshTable();
                } else {
                    JOptionPane.showMessageDialog(GUI.this, "Please select a ticket to delete.");
                }
            }
        });

        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        refreshTable();
    }

    private void refreshTable() {
        List<Ticket> tickets = TicketController.readTickets();
        tableModel.setTickets(tickets);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
}
