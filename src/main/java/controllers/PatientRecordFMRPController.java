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

public class PatientRecordFMRPController {

    @FXML
    private Pane patientRecordFMRPPane;
    @FXML
    private Button backBtn;
    @FXML
    private Button examBtn;

    @FXML
    public void backBtnHandle() {
        changeScene("/MedicalRecordsPage.fxml", 1000, 800);
    }

    @FXML
    public void examBtnHandle()  {
//        Stage stage = new Stage();
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/SymptomPage.fxml"));
//        try {
//            stage.initOwner(patientRecordFMRPPane.getScene().getWindow());
//            stage.setScene(new Scene((Parent) loader.load()));
//            stage.setTitle("Symptom Page");
//            stage.initModality(Modality.WINDOW_MODAL);
//            stage.showAndWait();
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }

        changeScene("/SymptomPage.fxml", 650, 500);

    }

    public void changeScene(String scene, int w, int h) {
        Stage stage = (Stage) patientRecordFMRPPane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(scene));
        try {
            stage.setScene(new Scene((Parent) loader.load(),w, h));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
