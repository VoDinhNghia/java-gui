package gui;

import java.awt.*;
import java.awt.event.*;

import constants.TextGui;
import gui.actions.CalculatorAction;

public class GuiMain extends Frame {
    public GuiMain() {
        Button btn = new Button(TextGui.btnCalculator);
        btn.setBounds(50, 50, 50, 50);
        add(btn);
        setSize(400, 500);
        setTitle(TextGui.titleMain);
        setLayout(new FlowLayout());
        setVisible(true);
        btn.addActionListener(new CalculatorAction());
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }
}
