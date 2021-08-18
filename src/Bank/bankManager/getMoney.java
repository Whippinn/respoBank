package Bank.bankManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Bank.*;
import Database.DBHelper;

public class getMoney {
    public void get(String email) throws SQLException {

        String sql = "select iduser,firstName,lastName,email,money from user";
        DBHelper helper = new DBHelper();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet;
        if(email == null || email.isEmpty()) {System.out.println("Null veya boş"); return;}
        try {
            User user = new User();
            connection = helper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                if (email.equals(resultSet.getString("email"))) {
                    System.out.println("ID: " + resultSet.getString("iduser"));
                    System.out.println("İsim soyisim : " + resultSet.getString("firstName") + " " + resultSet.getString("lastName"));
                    System.out.println("Para miktarı : " + resultSet.getDouble("money"));
                    break;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connection.close();
            statement.close();
        }
    }

    public double getMoneyFunction(String email) throws SQLException {
        String sql = "select iduser,firstName,lastName,email,money from user";
        DBHelper helper = new DBHelper();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet;
        if(email == null || email.isEmpty()) {System.out.println("Null veya boş");}
        try {
            User user = new User();
            connection = helper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                if (email.equals(resultSet.getString("email"))) {
                    return resultSet.getDouble("money");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connection.close();
            statement.close();
        }
        return 0;
    }
}
