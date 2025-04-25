
import java.sql.*;

public class Hotel {
    public static void listHotels() {
        try (Connection con = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM Hotels";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("Hotel ID: " + rs.getInt("hotel_id") + ", Name: " + rs.getString("name") + ", Location: " + rs.getString("location"));
         
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void checkRoomAvailability(int hotelId) {
        try (Connection con = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM Rooms_Availability";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
 
                       while (rs.next()) {
            
                System.out.println("Room ID: " + rs.getInt("room_id") + ", Type: " + rs.getString("room_type") + ", Price: $" + rs.getDouble("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
