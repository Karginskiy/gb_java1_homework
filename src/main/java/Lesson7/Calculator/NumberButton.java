package Lesson7.Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberButton extends JButton {

    private final Calculator calculator;

    NumberButton(String text, Calculator calculator) {
        super(text);
        this.calculator = calculator;
        addActionListener(new NumberActionListener());
    }

    private class NumberActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (calculator.isResult()) {
                calculator.getTextArea().setText(e.getActionCommand());
                calculator.setCurrentOperation("");
                calculator.setResult(false);
            } else {
                calculator.getTextArea().append(e.getActionCommand());
            }
        }
    }

}
