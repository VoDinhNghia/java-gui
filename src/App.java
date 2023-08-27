import database.UsersTable;
import gui.GuiMain;
import services.UserService;

public class App {
    static UserService userService = new UserService();
    public static void main(String[] args) throws Exception {
        new UsersTable();
        userService.initAdmin();
        new GuiMain();
    }
}
