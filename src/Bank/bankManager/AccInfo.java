package Bank.bankManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Database.DBHelper;

public class AccInfo {
    public void info(String email) throws SQLException {
        String sql = "select iduser,firstName,lastName,email,phoneNumber,money from user";
        Connection connection = null;
        DBHelper helper = new DBHelper();
        Statement statement = null;
        ResultSet resultSet;
        try {
            connection = helper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                if(email.equals(resultSet.getString("email"))) {
                    System.out.println("ID: " + resultSet.getInt("iduser"));
                    System.out.println("İsim: " + resultSet.getString("firstName"));
                    System.out.println("Soyisim: " + resultSet.getString("lastName"));
                    System.out.println("Email: " + resultSet.getString("email"));
                    System.out.println("Telefon numarası: " + resultSet.getString("phoneNumber"));
                    System.out.println("Para: " + resultSet.getDouble("money"));
                }
            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connection.close();
            statement.close();
        }
    }
}
