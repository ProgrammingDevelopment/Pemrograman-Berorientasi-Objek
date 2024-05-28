import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketController {
    public static void createTicket(Ticket ticket) {
        String sql = "INSERT INTO tickets(artist, date, price, quantity) VALUES(?, ?, ?, ?)";
        
        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, ticket.getArtist());
            pstmt.setString(2, ticket.getDate());
            pstmt.setInt(3, ticket.getPrice());
            pstmt.setInt(4, ticket.getQuantity());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Ticket> readTickets() {
        List<Ticket> tickets = new ArrayList<>();
        String sql = "SELECT * FROM tickets";

        try (Connection conn = Database.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Ticket ticket = new Ticket();
                ticket.setId(rs.getInt("id"));
                ticket.setArtist(rs.getString("artist"));
                ticket.setDate(rs.getString("date"));
                ticket.setPrice(rs.getInt("price"));
                ticket.setQuantity(rs.getInt("quantity"));
                tickets.add(ticket);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tickets;
    }

    public static void updateTicket(Ticket ticket) {
        String sql = "UPDATE tickets SET artist = ?, date = ?, price = ?, quantity = ? WHERE id = ?";

        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, ticket.getArtist());
            pstmt.setString(2, ticket.getDate());
            pstmt.setInt(3, ticket.getPrice());
            pstmt.setInt(4, ticket.getQuantity());
            pstmt.setInt(5, ticket.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteTicket(int id) {
        String sql = "DELETE FROM tickets WHERE id = ?";

        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
