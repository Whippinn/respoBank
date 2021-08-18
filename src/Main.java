import java.sql.SQLException;

import Bank.bankManager.*;

public class Main {

    public static void main(String[] args) throws SQLException, InterruptedException {
        user user = new user();
        user.registerAcc();
        user.loginAcc();
    }
}
