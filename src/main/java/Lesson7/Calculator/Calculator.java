package Lesson7.Calculator;

import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {

    final private JTextArea textArea;
    private Double firstNumber;
    private String currentOperation = "";
    private boolean isResult = false;

    public static void main(String[] args) {
        new Calculator();
    }

    Calculator() {

        setBounds(400, 400, 300, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Frame Calculator");

        textArea = new JTextArea(2, 10);
        textArea.setEnabled(false);
        textArea.setFont(new Font("Arial", Font.ITALIC, 34));
        add(textArea, BorderLayout.NORTH);

        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(5, 3, 5, 5));
        buttons.add(new NumberButton("1", this));
        buttons.add(new NumberButton("2", this));
        buttons.add(new NumberButton("3", this));
        buttons.add(new NumberButton("4", this));
        buttons.add(new NumberButton("5", this));
        buttons.add(new NumberButton("6", this));
        buttons.add(new NumberButton("7", this));
        buttons.add(new NumberButton("8", this));
        buttons.add(new NumberButton("9", this));
        buttons.add(new OperationButton("+", this));
        buttons.add(new NumberButton("0", this));
        buttons.add(new OperationButton("-", this));
        buttons.add(new OperationButton("/", this));
        buttons.add(new OperationButton("=", this));
        buttons.add(new OperationButton("*", this));

        add(buttons);
        setVisible(true);

    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public Double getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(Double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public String getCurrentOperation() {
        return currentOperation;
    }

    public void setCurrentOperation(String currentOperation) {
        this.currentOperation = currentOperation;
    }

    public void setResult(boolean result) {
        isResult = result;
    }

    public boolean isResult() {
        return isResult;
    }
}
