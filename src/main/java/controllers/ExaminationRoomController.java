package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class ExaminationRoomController {

    @FXML
    private Pane examinationRoomPane;

    @FXML
    public void backBtnHandle() {
        changeScene("/MainPage.fxml", 600, 500);
    }

    public void changeScene(String scene, int w, int h) {
        Stage stage = (Stage) examinationRoomPane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(scene));
        try {
            stage.setScene(new Scene((Parent) loader.load(),w, h));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
