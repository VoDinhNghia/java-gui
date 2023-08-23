import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import database.ConnectDb;
import services.AddTest;

public class App {
    public static void main(String[] args) throws Exception {
        int a = 10;
        int b = 20;
        int c = AddTest.add(a, b);
        Connection conn = ConnectDb.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery("SELECT * from users");
        while (result.next()) {
            System.out.println(result.getString(1) + " " + result.getString(2) + " " + result.getString(4) + " "
                    + result.getString(9));
        }
        System.out.println("Hello, World!" + c);
    }
}
