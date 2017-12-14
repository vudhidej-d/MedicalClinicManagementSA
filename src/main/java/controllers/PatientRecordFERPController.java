package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class PatientRecordFERPController {

    @FXML
    private Pane patientRecordPane;
    @FXML
    private Button backBtn;
    @FXML
    private Button createBtn;

    @FXML
    public void backBtnHandle() {
        changeScene("/ExaminationRoomPage.fxml", 1000, 800);
    }

    @FXML
    public void createBtnHandle()  { changeScene("/ExaminationPage.fxml", 650, 500); }

    public void changeScene(String scene, int w, int h) {
        Stage stage = (Stage) patientRecordPane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(scene));
        try {
            stage.setScene(new Scene((Parent) loader.load(),w, h));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}