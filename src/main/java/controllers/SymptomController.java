package controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import models.Patient;
import models.Symptom;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SymptomController {

    private DBController db = new DBController();
    private Patient patient;

    @FXML
    private Pane symtomPane;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextArea infoField;
    @FXML
    private TextField staffIDField;
    @FXML
    private TextField roomField;
    @FXML
    private Label patientLabel;

    @FXML
    public void initialize() {
        Platform.runLater(new Runnable() {
            public void run() {
                datePicker.setValue(LocalDate.now());
                patientLabel.setText(patient.getPatientID() + ": " + patient.getFullName());
            }
        });
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
        if (check()) {
            Symptom symptom = new Symptom(datePicker.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yy")), infoField.getText(), patient.getPatientID(), Integer.parseInt(staffIDField.getText()));
            db.insertSymptom(symptom);
            db.updateStatus(roomField.getText(), patient.getPatientID());
            patient.addSymptom(symptom);
            changeScene("/MedicalRecordsPage.fxml", 1000, 800);
        }
    }

    private boolean check() {
        if (datePicker.getValue() != null && !infoField.getText().isEmpty() && isNumeric(staffIDField.getText()) && isNumeric(roomField.getText())) {
            int roomNum = Integer.parseInt(roomField.getText());
            int staffID = Integer.parseInt(staffIDField.getText());
            boolean result1 = false;
            boolean result2 = false;
            for (int i: db.selectRoomNumbers()) {
                if (roomNum == i) {
                    result1 = true;
                    break;
                }
            }
            for (int j: db.selectAllStaffID()) {
                if (staffID == j) {
                    result2 = true;
                    break;
                }
            }
            return result1 && result2;

        }
        return false;
    }

    private boolean isNumeric(String s) {
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");
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

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}