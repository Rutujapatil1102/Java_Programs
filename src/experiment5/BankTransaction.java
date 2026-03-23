package experiment5;
import java.sql.*;

public class BankTransaction {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/bankdb";
        String user = "root";
        String password = "root";

        Connection con = null;

        try {
            // Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Connection
            con = DriverManager.getConnection(url, user, password);

            // Disable auto-commit (Start transaction)
            con.setAutoCommit(false);

            // Transfer amount
            int fromAcc = 101;
            int toAcc = 102;
            double amount = 1000;

            // Deduct from sender
            PreparedStatement ps1 = con.prepareStatement(
                "UPDATE account SET balance = balance - ? WHERE acc_no = ?"
            );
            ps1.setDouble(1, amount);
            ps1.setInt(2, fromAcc);
            ps1.executeUpdate();

            // Check balance (optional safety check)
            PreparedStatement check = con.prepareStatement(
                "SELECT balance FROM account WHERE acc_no = ?"
            );
            check.setInt(1, fromAcc);
            ResultSet rs = check.executeQuery();

            if (rs.next() && rs.getDouble("balance") < 0) {
                throw new Exception("Insufficient Balance!");
            }

            // Add to receiver
            PreparedStatement ps2 = con.prepareStatement(
                "UPDATE account SET balance = balance + ? WHERE acc_no = ?"
            );
            ps2.setDouble(1, amount);
            ps2.setInt(2, toAcc);
            ps2.executeUpdate();

            // Commit transaction
            con.commit();
            System.out.println("Transaction Successful!");

        } catch (Exception e) {
            try {
                if (con != null) {
                    con.rollback(); // Undo all operations
                    System.out.println("Transaction Failed! Rolled back.");
                }
            } catch (SQLException se) {
                System.out.println(se);
            }
            System.out.println(e);

        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
}