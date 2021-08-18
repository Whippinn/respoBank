package Bank.bankManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import Bank.User;
import Bank.bankManager.*;
import Database.DBHelper;

public class depositMoney {
    public void deposit(String email) throws SQLException {
        User user = new User();
        Scanner scanner =  new Scanner(System.in);

        System.out.println("Ne kadar para yatırmak istiyorsun? ");
        double depositMoney = scanner.nextDouble();
        getMoney getMoney = new getMoney();
        double money = getMoney.getMoneyFunction(email);
        double total = depositMoney + money;

        String sql = "update user set money = ? where email = '"+email+"'";
        Connection connection = null;
        DBHelper helper = new DBHelper();
        PreparedStatement statement = null;
        try {
            connection = helper.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setDouble(1, total);
            statement.executeUpdate();
            System.out.println("Mevcut bakiyeniz: " + getMoney.getMoneyFunction(email));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connection.close();
            statement.close();
        }
    }
}
