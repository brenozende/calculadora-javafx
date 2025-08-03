module br.com.brenozende.calculadora {
    requires javafx.controls;
    requires javafx.fxml;


    opens br.com.brenozende.calculadora to javafx.fxml;
    exports br.com.brenozende.calculadora;
}