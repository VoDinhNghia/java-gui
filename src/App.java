import database.ConnectDb;
import services.AddTest;

public class App {
    public static void main(String[] args) throws Exception {
        int a = 10;
        int b = 20;
        int c = AddTest.add(a, b);
        ConnectDb.getConnection();
        System.out.println("Hello, World!" + c);
    }
}
