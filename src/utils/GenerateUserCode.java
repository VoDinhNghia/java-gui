package utils;

import java.util.Calendar;
import java.util.Random;

public class GenerateUserCode {
    private Calendar calendar = Calendar.getInstance();
    private Random random = new Random();

    public String code() {
        int year = calendar.get(1);
        int month = calendar.get(2) + 1;
        int date = calendar.get(5);
        int randomNumber = random.nextInt(10000);
        String numberCode = year + "" + month + "" + date + "" + randomNumber;
        return numberCode;
    }
}
