import database.UsersTable;
import gui.GuiMain;

public class App {
    public static void main(String[] args) throws Exception {
        new UsersTable();
        new GuiMain();
    }
}
