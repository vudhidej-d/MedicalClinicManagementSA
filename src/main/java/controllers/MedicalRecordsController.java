package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MedicalRecordsController {

    @FXML
    private Pane medicalRecordsPane;
    @FXML
    private Button backBtn;
    @FXML
    private Button createBtn;
    @FXML
    private Button searchBtn;

    @FXML
    public void backBtnHandle() {
        changeScene("/MainPage.fxml", 600, 500);
    }

    @FXML
    public void searchBtnHandle() {

    }

    @FXML
    public void createBtnHandle()  {
        changeScene("/CreateMedicalRecordPage.fxml", 650, 400);
    }

    public void changeScene(String scene, int w, int h) {
        Stage stage = (Stage) medicalRecordsPane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(scene));
        try {
            stage.setScene(new Scene((Parent) loader.load(),w, h));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
