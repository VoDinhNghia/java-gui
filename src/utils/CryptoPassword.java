package utils;

import java.security.MessageDigest;

public class CryptoPassword {
    public String endCode(String password) {
        try {
            MessageDigest ms = MessageDigest.getInstance("MD5");
            ms.update(password.getBytes());
            byte[] bytes = ms.digest();
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            return s.toString();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
