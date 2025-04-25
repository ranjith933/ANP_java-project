
import java.sql.*;

public class Customer {
    public static void registerCustomer(String name, String email, String phone, String password) {
        try (Connection con = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO Customer (name, email, phone, password) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setString(4, password);
            ps.executeUpdate();
            System.out.println("Customer registered successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
    }

    public static boolean loginCustomer(String email, String password) {
        try (Connection con = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM Customer WHERE email = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                System.out.println("Login successful! Welcome, " + rs.getString("name") + "!");
                return true; // Customer exists
            } else {
                System.out.println("Invalid email or password. Please try again.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return false;
        }
    }
}
