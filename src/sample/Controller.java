package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    private Button btnOK;
    @FXML
    private Label imeesage;

    public void handlerOk(ActionEvent actionEvent) {
        imeesage.setText("Ok is clicked");
    }

}
