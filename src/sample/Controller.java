package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javafx.scene.control.ComboBox;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    /**
     * Вот оно, родимое, под текстовое поле с именем txtInput
     * а использование так называемого декоратора @FXML
     * позволит ссылаться на это поле из fxml файла
     */
    @FXML
    private TextField x_re;
    @FXML
    private TextField y_re;
    @FXML
    private TextField x_im;
    @FXML
    private TextField y_im;
    @FXML
    private TextField txtResult;
    @FXML
    private ComboBox<String> comboBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBox.getItems().setAll(
                "Сложение",
                "Вычитание",
                "Умножение",
                "Деление",
                "Сравнение"
        );
    }
    public void Btn_clicked() {
        int xRe= Integer.parseInt(x_re.getText());
        int xIm= Integer.parseInt(x_im.getText());
        int yRe= Integer.parseInt(y_re.getText());
        int yIm= Integer.parseInt(y_im.getText());

        ComplexNumber X = new ComplexNumber(xRe,xIm);
        ComplexNumber Y = new ComplexNumber(yRe,yIm);

        String selectedValue = comboBox.getSelectionModel().getSelectedItem();
        ComplexNumber res;
        switch (selectedValue)
        {
            case "Сложение" : {
                res=ComplexNumber.sum(X,Y);
                if (res.getIm()>0 || res.getIm()==0) txtResult.setText(String.valueOf(res.getRe()) + "+" +String.valueOf( res.getIm())+"i");
                else txtResult.setText(String.valueOf(res.getRe()) +  String.valueOf( res.getIm()));
                break;
            }
            case "Вычитание" : {
                res=ComplexNumber.subtract(X,Y);
                if (res.getIm()>0|| res.getIm()==0) txtResult.setText(String.valueOf(res.getRe()) + "+" +String.valueOf( res.getIm())+"i");
                else txtResult.setText(String.valueOf(res.getRe()) +  String.valueOf( res.getIm()));
                break;
            }
            case "Умножение" : {
                res=ComplexNumber.multiply(X,Y);
                if (res.getIm()>0|| res.getIm()==0) txtResult.setText(String.valueOf(res.getRe()) + "+" +String.valueOf( res.getIm())+"i");
                else txtResult.setText(String.valueOf(res.getRe())  +  String.valueOf( res.getIm()));
                break;
            }
            case "Деление" : {
                res=ComplexNumber.divide(X,Y);
                if (res.getIm()>0|| res.getIm()==0) txtResult.setText(String.valueOf(res.getRe()) + "+" +String.valueOf( res.getIm())+"i");
                else txtResult.setText(String.valueOf(res.getRe()) +  String.valueOf( res.getIm()));
                break;
            }
            case "Сравнение" : {
                    if (ComplexNumber.compare(X, Y)) txtResult.setText("Число 1 > Числа 2");
                    else txtResult.setText("Число 1 < Числа 2");  break;}

        }

    }
}
