package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.Patient;
import models.Symptom;

import java.io.IOException;

public class MainPageController {

    DBController db = new DBController();

    @FXML
    private Pane mainPane;

    @FXML
    public void initialize() {
        Patient.currentID = db.getLastID("Patient")+1;
        Symptom.currentID = db.getLastID("Symptom")+1;
    }

    @FXML
    public void medicalRecordsBtnHandle() {
        changeScene("/MedicalRecordsPage.fxml", 1000, 800);
    }

    @FXML
    public void examinationRoomBtnHandle() {
        changeScene("/ExaminationRoomPage.fxml", 1000, 800);
    }

    @FXML
    public void dispensaryBtnHandle() {
        changeScene("/DispensaryPage.fxml", 1000, 800);
    }

    public void changeScene(String scene, int w, int h) {
        Stage stage = (Stage) mainPane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(scene));
        try {
            stage.setScene(new Scene((Parent) loader.load(),w, h));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}