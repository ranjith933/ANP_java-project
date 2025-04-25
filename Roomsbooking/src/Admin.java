
import java.sql.*;

public class Admin {
    // Admin login credentials stored in the database
    public boolean loginAdmin(String email, String password) {
        try (Connection con = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM Admin WHERE email = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void viewAllCustomers() {
        try (Connection con = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM Customer";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            System.out.println("\nCustomers:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("customer_id") + ", Name: " + rs.getString("name") + ", Email: " + rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewAllHotels() {
        try (Connection con = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM Hotels";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            System.out.println("\nHotels:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("hotel_id") + ", Name: " + rs.getString("hotel_name") + ", Location: " + rs.getString("location"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewAllRooms() {
        try (Connection con = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM Rooms_Availability";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            System.out.println("\nRooms:");
            while (rs.next()) {
                System.out.println("Room ID: " + rs.getInt("room_id") + ", Hotel ID: " + rs.getInt("hotel_id") + ", Available: " + rs.getBoolean("is_available"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewAllBookings() {
        try (Connection con = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM Bookings";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            System.out.println("\nBookings:");
            while (rs.next()) {
                System.out.println("Booking ID: " + rs.getInt("booking_id") + ", Customer ID: " + rs.getInt("customer_id") + ", Hotel ID: " + rs.getInt("hotel_id") + ", Room ID: " + rs.getInt("room_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        public void deleteCustomer(int customerId) {
            try (Connection con = DatabaseConnection.getConnection()) {
                String sql = "DELETE FROM Customer WHERE customer_id = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, customerId);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Customer with ID " + customerId + " deleted successfully.");
                } else {
                    System.out.println("No customer found with ID " + customerId);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}
