package database;

import java.sql.Connection;
import java.sql.DriverManager;

import constants.ConfigDb;

public class ConnectDb {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(ConfigDb.DB_URL, ConfigDb.USERNAME, ConfigDb.PASSWORD);
            System.out.println("Connected success");
            return conn;
        } catch (Exception e) {
            System.out.println("Connect failed!");
            e.printStackTrace();
            return null;
        }
    }
}
