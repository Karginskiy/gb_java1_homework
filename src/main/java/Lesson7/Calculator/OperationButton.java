package Lesson7.Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperationButton extends JButton {

    private final Calculator calculator;

    OperationButton(String string, Calculator calculator) {
        super(string);
        this.calculator = calculator;
        addActionListener(new OperationButtonHandler());
    }

    private class OperationButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            double result;

            try {
                if (calculator.getTextArea().getText().equals("") && calculator.getFirstNumber() != null) {
                    calculator.setCurrentOperation(e.getActionCommand());
                } else if (calculator.isResult()) {
                    calculator.setCurrentOperation(e.getActionCommand());
                    calculator.getTextArea().setText("");
                } else if (!calculator.getTextArea().getText().equals("")) {
                    if (calculator.getFirstNumber() != null) {
                        switch (calculator.getCurrentOperation()) {
                            case "+":
                                result = calculator.getFirstNumber() + Double.parseDouble(calculator.getTextArea().getText());
                                calculator.getTextArea().setText(result + "");
                                calculator.setFirstNumber(result);
                                calculator.setResult(true);
                                if (!e.getActionCommand().equals("="))
                                calculator.setCurrentOperation(e.getActionCommand());
                                break;
                            case "-":
                                result = calculator.getFirstNumber() - Double.parseDouble(calculator.getTextArea().getText());
                                calculator.getTextArea().setText(result + "");
                                calculator.setFirstNumber(result);
                                calculator.setResult(true);
                                if (!e.getActionCommand().equals("="))
                                calculator.setCurrentOperation(e.getActionCommand());
                                break;
                            case "*":
                                result = calculator.getFirstNumber() * Double.parseDouble(calculator.getTextArea().getText());
                                calculator.getTextArea().setText(result + "");
                                calculator.setFirstNumber(result);
                                calculator.setResult(true);
                                if (!e.getActionCommand().equals("="))
                                calculator.setCurrentOperation(e.getActionCommand());
                                break;
                            case "/":
                                if (calculator.getTextArea().getText().equals("0")) {
                                    calculator.getTextArea().setText("Error! Division by zero!");
                                    calculator.setFirstNumber(null);
                                    calculator.setCurrentOperation("");
                                }
                                result = calculator.getFirstNumber() / Double.parseDouble(calculator.getTextArea().getText());
                                calculator.getTextArea().setText(result + "");
                                calculator.setFirstNumber(result);
                                calculator.setResult(true);
                                if (!e.getActionCommand().equals("="))
                                calculator.setCurrentOperation(e.getActionCommand());
                                break;
                            case "=":
                                actionPerformed(e);
                                break;
                            default:
                                calculator.setFirstNumber(Double.parseDouble(calculator.getTextArea().getText()));
                                calculator.setCurrentOperation(e.getActionCommand());
                                calculator.getTextArea().setText("");
                        }
                    } else if (calculator.getFirstNumber() == null && calculator.getCurrentOperation().equals("")) {
                        calculator.setFirstNumber(Double.parseDouble(calculator.getTextArea().getText()));
                        calculator.setCurrentOperation(e.getActionCommand());
                        calculator.getTextArea().setText("");
                    }
                }
            } catch (Exception e1) {
                calculator.setCurrentOperation("");
                calculator.setFirstNumber(null);
                calculator.setResult(false);
            }

        }
    }

}
