package services;

import java.sql.Connection;
import java.sql.Statement;

import configs.ConnectDb;
import constants.TableName;

public class UserService {
    public void createNewUser(String name, String password, String email, String code, Boolean gender, int age) {
        try {
            Connection conn = ConnectDb.getConnection();
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO " + TableName.users + " ()";
            stmt.executeUpdate(sql);
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
