package gui;

import java.awt.*;
import java.awt.event.*;

import gui.actions.CaculatorAction;

public class GuiMain extends Frame {
    public GuiMain() {
        Button btn = new Button("Calculator");
        btn.setBounds(50, 50, 50, 50);
        add(btn);
        setSize(400, 500);
        setTitle("Caculator program");
        setLayout(new FlowLayout());
        setVisible(true);
        btn.addActionListener(new CaculatorAction());
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }
}
