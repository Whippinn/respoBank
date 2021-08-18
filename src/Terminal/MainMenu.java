package Terminal;

import java.sql.SQLException;
import java.util.Scanner;

import Bank.bankManager.*;

public class MainMenu {
    public void menu(String email) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int secim;

        System.out.println("Ne yapmak istiyorsun?\n1 - Paranı göster\n2 - Para yatır\n3 - Para çek\n4 - Hesap bilgilerini göster");
        secim = scanner.nextInt();
        switch (secim) {
            case 1:
                getMoney getMoney = new getMoney();
                getMoney.get(email);
                break;
            case 2:
                depositMoney depositMoney = new depositMoney();
                depositMoney.deposit(email);
                break;
            case 3:
                withdrawMoney withdrawMoney = new withdrawMoney();
                withdrawMoney.withdraw(email);
                break;
            case 4:
            default:
                AccInfo accInfo = new AccInfo();
                accInfo.info(email);
                break;
        }
    }
}
