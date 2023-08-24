package gui;

import java.awt.*;
import java.awt.event.*;

public class GuiMain extends Frame {
    public GuiMain() {
        Button btn = new Button("Test");
        btn.setBounds(50, 50, 50, 50);
        add(btn);
        setSize(150, 150);
        setTitle("This is my First AWT example");
        setLayout(new FlowLayout());
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }
}
