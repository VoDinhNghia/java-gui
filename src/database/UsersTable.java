package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import configs.ConnectDb;
import constants.TableName;

public class UsersTable {

    public UsersTable() throws SQLException {
        try {
            Connection conn = ConnectDb.getConnection();
            Statement stmt = conn.createStatement();
            String sql = "CREATE table " + TableName.users +
                    "(id INTEGER NOT NULL AUTO_INCREMENT, " +
                    " name VARCHAR(255), " +
                    " email VARCHAR(255), " +
                    " password VARCHAR(255), " +
                    " code VARCHAR(20), " +
                    " role VARCHAR(50), " +
                    " age INTEGER, " +
                    " gender BOOLEAN, " +
                    " created_at DATETIME, " +
                    " updated_at DATETIME, " +
                    "PRIMARY KEY ( id ))";
            stmt.executeUpdate(sql);
            System.out.println("Create table " + TableName.users + " success.");
            conn.close();
        } catch (Exception e) { }
    }
}
