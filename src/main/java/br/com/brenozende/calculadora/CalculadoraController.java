package br.com.brenozende.calculadora;

import br.com.brenozende.calculadora.enums.OperationEnum;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraController {
    @FXML
    private TextArea display;

    private final List<Integer> values = new ArrayList<>();

    private OperationEnum operation;

    @FXML
    protected void onNumberClick(ActionEvent event) {
        Button button = (Button) event.getSource();
        display.setText(display.getText().concat(button.getText()));
    }

    @FXML
    protected void onOperationButton(ActionEvent event) {
        Button button = (Button) event.getSource();
        String operationButton = button.getText();
        if (!display.getText().isBlank()) {
            switch (operationButton) {
                case "+" -> {
                    operation = OperationEnum.PLUS;
                }
                case "-" -> {
                    operation = OperationEnum.MINUS;
                }
                case "*" -> {
                    operation = OperationEnum.TIMES;
                }
                case "/" -> {
                    operation = OperationEnum.DIVISION;
                }
            }
            values.add(Integer.parseInt(display.getText()));
            display.setText("");
        }
    }

    @FXML
    protected void equals() {
        if (!values.isEmpty() && !display.getText().isBlank()) {
            switch (operation) {
                case TIMES -> {
                    int result = values.getFirst() * Integer.parseInt(display.getText());
                    display.setText(String.valueOf(result));
                    values.clear();
                }
                case PLUS -> {
                    int result = values.getFirst() + Integer.parseInt(display.getText());
                    display.setText(String.valueOf(result));
                    values.clear();
                }
                case MINUS -> {
                    int result = values.getFirst() - Integer.parseInt(display.getText());
                    display.setText(String.valueOf(result));
                    values.clear();
                }
                case DIVISION -> {
                    if (Integer.parseInt(display.getText()) == 0)
                        display.setText("Error");
                    else {
                        int result = values.getFirst() / Integer.parseInt(display.getText());
                        display.setText(String.valueOf(result));
                        values.clear();
                    }
                }
            }
        }
    }

    @FXML
    protected void clear(){
        display.setText("");
        values.clear();
        operation = null;
    }
}