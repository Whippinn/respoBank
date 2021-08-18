package Bank.bankManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import Bank.User;
import Control.*;
import Database.DBHelper;
import Terminal.MainMenu;

public class user extends User {

    public void registerAcc() throws InterruptedException, SQLException {
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kayıt paneli");
        System.out.println("İsim belirtiniz;");
        user.setFirstName(scanner.next());
        System.out.println("Soy isim belirtiniz;");
        user.setLastName(scanner.next());
        System.out.println("Yaş belirtiniz;");
        user.setAge(scanner.nextInt());
        System.out.println("Email belirtiniz;");
        user.setEmail(scanner.next());
        System.out.println("Şifre belirtiniz;");
        user.setPassword(scanner.next());
        System.out.println("Telefon numarası belirtiniz;");
        user.setPhoneNumber(scanner.next());
        System.out.println("--------------------");
        System.out.println("Kayıt başarılı.");
        System.out.print("Bilgiler yükleniyor.");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.print(".\n");
        System.out.println("İsim: " + user.getFirstName());
        System.out.println("Soy isim: " + user.getLastName());
        System.out.println("Yaş: " + user.getAge());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Telefon numarası: " + user.getPhoneNumber());
        Connection connection = null;
        DBHelper helper = new DBHelper();
        PreparedStatement statement = null;
        String sql = "insert into user (firstName,lastName,age,money,phoneNumber,email,password) values(?,?,?,?,?,?,?)";
        registerControl registerControl = new registerControl();
        if (registerControl.ageControl(user)) {
            try {
                connection = helper.getConnection();
                statement = connection.prepareStatement(sql);
                statement.setString(1, user.getFirstName());
                statement.setString(2, user.getLastName());
                statement.setInt(3, user.getAge());
                statement.setDouble(4, 0);
                statement.setString(5, user.getPhoneNumber());
                statement.setString(6, user.getEmail());
                statement.setString(7, user.getPassword());
                statement.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } finally {
                connection.close();
                statement.close();
            }
        } else {
            System.out.println("Tüm her şey eksiksiz doldurulmalı ve yaşınız 18'den büyük olmalı.");
        }
    }

    public void loginAcc() throws InterruptedException, SQLException {
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Giriş paneli");
        System.out.println("Email giriniz;");
        String email = scanner.next();
        user.setEmail(email);
        System.out.println("Şifre giriniz;");
        user.setPassword(scanner.next());
        System.out.print("Kontrol sağlanıyor.");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.print(".\n");
        loginControl loginControl = new loginControl();
        if (loginControl.control(user)) {
            System.out.println("Giriş başarıyla gerçekleşti.");
            MainMenu mainMenu = new MainMenu();
            mainMenu.menu(email);
            Thread.sleep(1000);
        } else {
            System.out.println("Şifre veya email yanlış.");
        }
    }
}
