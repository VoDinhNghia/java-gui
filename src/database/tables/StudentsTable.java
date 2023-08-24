package database.tables;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.ConnectDb;

public class StudentsTable {
    private String tableName = "STUDENTS";

    public StudentsTable() throws SQLException {
        try {
            Connection conn = ConnectDb.getConnection();
            DatabaseMetaData metaData = conn.getMetaData();
            ResultSet result = metaData.getTables(null, null, this.tableName, new String[] { "TABLE" });
            if (result.next()) {
                System.out.println("Table " + this.tableName + " existed already.");
            } else {
                Statement stmt = conn.createStatement();
                String sql = "CREATE table " + this.tableName +
                        "(id INTEGER NOT NULL AUTO_INCREMENT, " +
                        " name VARCHAR(255), " +
                        " code VARCHAR(20), " +
                        " age INTEGER, " +
                        " gender BOOLEAN, " +
                        "PRIMARY KEY ( id ))";
                stmt.executeUpdate(sql);
                System.out.println("Create table " + this.tableName + " success.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
