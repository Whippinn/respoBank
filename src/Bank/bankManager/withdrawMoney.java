package Bank.bankManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import Database.DBHelper;

public class withdrawMoney {
    public void withdraw(String email) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ne kadar para çekmek istiyorsunuz?");
        double depositMoney = scanner.nextDouble();
        getMoney getMoney = new getMoney();
        double money = getMoney.getMoneyFunction(email);
        double total = money - depositMoney;
        if(total < -500) {
            double cekilebilir = money-(-500);
            System.out.println("Çekmek istediğiniz miktar ile hesap bakiyeniz 500₺'a ulaşmakta.");
            System.out.println("Güncel hesap bakiyeniz: " + money);
            System.out.println("Çekilebilenecek bakiye: " + cekilebilir);
            return;
        }
        String sql = "update user set money = ? where email = '"+email+"'";
        Connection connection = null;
        DBHelper helper = new DBHelper();
        PreparedStatement statement = null;
        try {
            connection = helper.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setDouble(1, total);
            //statement.setString(2, email);
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
