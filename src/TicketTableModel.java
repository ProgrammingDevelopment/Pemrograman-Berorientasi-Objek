import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TicketTableModel extends AbstractTableModel {
    private List<Ticket> tickets;
    private String[] columnNames = {"ID", "Artist", "Date", "Price", "Quantity"};

    public TicketTableModel() {
        tickets = new ArrayList<>();
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
        fireTableDataChanged();
    }

    public Ticket getTicketById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    @Override
    public int getRowCount() {
        return tickets.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Ticket ticket = tickets.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return ticket.getId();
            case 1:
                return ticket.getArtist();
            case 2:
                return ticket.getDate();
            case 3:
                return ticket.getPrice();
            case 4:
                return ticket.getQuantity();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
