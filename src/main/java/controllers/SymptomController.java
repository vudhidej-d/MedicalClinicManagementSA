package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import models.Patient;
import models.Symptom;

import java.io.IOException;

public class SymptomController {

    @FXML
    private Pane symtomPane;
    @FXML
    private Button backBtn;
    @FXML
    private Button submitBtn;
    @FXML
    private TextField dateField;
    @FXML
    private TextArea infoField;
    @FXML
    private TextField staffIDField;
    @FXML
    private TextField roomField;
    @FXML
    private Label patientLabel;

    private Patient patient;

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @FXML
    public void backBtnHandle() {
        Stage stage = (Stage) symtomPane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/PatientRecordPageFMRP.fxml"));
        try {
            stage.setScene(new Scene((Parent) loader.load(),1000, 800));
            PatientRecordFMRPController controller = loader.getController();
            controller.setPatient(patient);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void submitBtnHandle()  {
//        patient.addSymptom(new Symptom(dateField.getText(), infoField.getText(), patient.getPatientID(), staffIDField.getText()));
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ExaminationRoomPage.fxml"));
//        ExaminationRoomController controller = loader.getController();
//        controller.addPatient(patient);
//        changeScene("/MedicalRecordsPage.fxml", 1000, 800);
    }

    public void changeScene(String scene, int w, int h) {
        Stage stage = (Stage) symtomPane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(scene));
        try {
            stage.setScene(new Scene((Parent) loader.load(),w, h));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}