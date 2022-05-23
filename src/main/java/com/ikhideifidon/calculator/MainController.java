package com.ikhideifidon.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController {

    @FXML
    private Label result;
    private float number1 = 0;
    private String operator = "";
    private boolean start = true;
    private final Model model = new Model();


    @FXML
    public void processNumbers(ActionEvent event) {
        if (start) {
            result.setText("");
            start = false;
        }
        String value = ((Button)event.getSource()).getText();
        result.setText(result.getText() + value);
    }

    @FXML
    public void processBinaryOperators(ActionEvent event) {
        String value =((Button)event.getSource()).getText();
        if (!value.equals("")) {
            if (!value.equals("=")) {
                operator = value;
                number1 = Long.parseLong(result.getText());
                result.setText("");
            } else {
                if (!operator.equals("")) {
                    float number2 = Float.parseFloat(result.getText());
                    float output = model.calculateBinaryNumber(number1, number2, operator);
                    result.setText(String.valueOf(output));
                    operator = "";
                    start = true;
                }
            }
        }
    }

    @FXML
    public void processUnaryOperators(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        if (!operator.isEmpty())
            return;

        operator = value;
        number1 = Float.parseFloat(result.getText());
        result.setText("");
        float output = model.calculateUnaryNumber(number1, operator);
        result.setText(String.valueOf(output));
        operator = "";
    }

    @FXML
    public void processClearOperation() {
        operator = "";
        start = true;
        result.setText("0.0");
    }


}