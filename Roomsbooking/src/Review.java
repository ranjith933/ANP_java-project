
import java.sql.*;

public class Review {
    public static void addReview(int customerId, int hotelId, int rating, String comment) {
        try (Connection con = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO Reviews (customer_id, hotel_id, rating, comment) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, customerId);
            ps.setInt(2, hotelId);
            ps.setInt(3, rating);
            ps.setString(4, comment);
            ps.executeUpdate();
            System.out.println("Review added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void viewReviews(int hotelId) {
        try (Connection con = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM Reviews WHERE hotel_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, hotelId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("Rating: " + rs.getInt("rating") + " - " + rs.getString("comment"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
