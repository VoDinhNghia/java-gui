package gui.screens;

import java.awt.*;
import java.awt.event.*;

import constants.TextGui;

public class LoginGUI extends Frame{
    public LoginGUI() {
        setSize(1000, 600);
        setTitle(TextGui.titleMain);
        setLayout(new FlowLayout());
        setVisible(true);
        Label labelLogin = new Label(TextGui.labelLogin);
        labelLogin.setBounds(50, 50, 50, 50);
        labelLogin.setForeground(Color.RED);
        add(labelLogin);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }
}
