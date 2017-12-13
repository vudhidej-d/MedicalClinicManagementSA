package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.Patient;

import java.io.IOException;

public class MainPageController {

    @FXML
    private Pane mainPane;

    @FXML
    public void initialize() {
        DBController db = new DBController();
        db.selectPatientRecords();
        String[] i = {"Test", "Test"};
        db.insertPatientRecord(new Patient("5", "Test", "Test", "Test", "MALE",
                "Test", "Test", "O", "Test", "Test", "Test", i));
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
