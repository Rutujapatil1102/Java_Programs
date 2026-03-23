package experiment4;
import java.sql.*;

public class RetrieveProduct {
    public static void main(String[] args) {

        // Database URL, Username, Password
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "root";

        try {
            // 1. Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish Connection
            Connection con = DriverManager.getConnection(url, user, password);

            // 3. Create Statement
            Statement stmt = con.createStatement();

            // 4. Execute Query
            String query = "SELECT * FROM product";
            ResultSet rs = stmt.executeQuery(query);

            // 5. Process Result
            System.out.println("Product Details:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");

                System.out.println(id + " " + name + " " + price);
            }

            // 6. Close Resources
            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}