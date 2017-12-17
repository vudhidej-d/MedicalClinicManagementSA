package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AlertController {

    private Stage stage;

    @FXML
    private Label popupLabel;

    @FXML
    public void okBtnHandle() {
        stage.close();
    }

    public Label getPopupLabel() {
        return popupLabel;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
