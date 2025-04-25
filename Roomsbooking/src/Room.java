
import java.sql.*;

public class Room {
    public static void bookRoom(int hotelId, int roomId) {
        try (Connection con = DatabaseConnection.getConnection()) {
            // Check if the room is available
            String checkSql = "SELECT is_available FROM Rooms_Availability WHERE room_id = ?";
            PreparedStatement checkStmt = con.prepareStatement(checkSql);
            checkStmt.setInt(1, hotelId);
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next() && !rs.getBoolean("is_available")) {
                System.out.println("Room is not available!");
                return;
            }

            // Update room availability
            String updateSql = "UPDATE Rooms_Availability SET is_available = FALSE WHERE room_id = ?";
            PreparedStatement updateStmt = con.prepareStatement(updateSql);
            updateStmt.setInt(1, roomId);
            updateStmt.executeUpdate();

            System.out.println("Room booked successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
