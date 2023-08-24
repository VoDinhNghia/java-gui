import database.tables.StudentsTable;
import gui.GuiMain;

public class App {
    public static void main(String[] args) throws Exception {
        new StudentsTable();
        new GuiMain();
    }
}
