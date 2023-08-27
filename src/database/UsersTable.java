package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import configs.ConnectDb;
import constants.TableName;

public class UsersTable {

    public UsersTable() throws SQLException {
        try {
            Connection conn = ConnectDb.getConnection();
            DatabaseMetaData metaData = conn.getMetaData();
            ResultSet result = metaData.getTables(null, null, TableName.users, new String[] { "TABLE" });
            if (result.next()) {
                System.out.println("Table " + TableName.users + " existed already.");
            } else {
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
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}