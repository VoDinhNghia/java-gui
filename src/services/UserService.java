package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;

import configs.ConnectDb;
import constants.Constant;
import constants.TableName;
import utils.CryptoPassword;

public class UserService {
    private CryptoPassword cryptoPassword = new CryptoPassword();
    private Calendar calendar = Calendar.getInstance();

    public void createNewUser(String name, String password, String code, String email, String role, Boolean gender, int age) {
        try {
            Connection conn = ConnectDb.getConnection();
            String endcodePass = cryptoPassword.endCode(password);
            int month = calendar.get(2) + 1;
            String createdAt = calendar.get(1) + "-" + month + "-" + calendar.get(5) + " " + calendar.get(10) + ":" + calendar.get(12) + ":" + calendar.get(13);
            PreparedStatement ps = conn.prepareStatement("INSERT INTO " + TableName.users + " (name, email, password, code, role, age, gender, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, endcodePass);
            ps.setString(4, code);
            ps.setString(5, role);
            ps.setBoolean(6, gender);
            ps.setInt(7, age);
            ps.setString(8, createdAt);
            ps.setString(9, null);
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void initAdmin() {
        try {
            Connection conn = ConnectDb.getConnection();
            Statement stmt = conn.createStatement();
            String code = "Admin-App-2023";
            ResultSet result = stmt.executeQuery("SELECT * from " + TableName.users + " WHERE code = '" + code + "'");
            if (result.next()) {
                System.out.println("Admin existed already " + result.getString(2));
            } else {
                String name = "AdminApp";
                String password = "admin123@";
                String email = "vodinhnghia85@gmail.com";
                String role = Constant.adminRole;
                Boolean gender = true;
                int age = 28;
                this.createNewUser(name, password, code, email , role, gender, age);
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
