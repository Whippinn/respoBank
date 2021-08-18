package Control;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Bank.User;
import Database.DBHelper;

public class loginControl {
    public boolean control(User user) throws SQLException {
        String sql = "select email,password from user";
        Connection connection = null;
        DBHelper helper = new DBHelper();
        Statement statement = null;
        ResultSet resultSet;
        try {
            connection = helper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                if (user.getEmail().equals(resultSet.getString("email")) && user.getPassword().equals(resultSet.getString("password"))) {
                    user.setEmail(resultSet.getString("email"));
                    return true;
                }
            }
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        } finally {
            connection.close();
            statement.close();
        }
        return false;
    }
}
