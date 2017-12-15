package controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import models.Patient;
import models.Result;

import java.awt.*;

public class ExaminationResultFERPController {

    private Result result;
    private Patient patient;

    @FXML
    private Label patientLabel;
    @FXML
    private Label resultIDLabel;
    @FXML
    private Label dateLabel;
    @FXML
    private Label infoLabel;
    @FXML
    private Label prescriptionLabel;

    @FXML
    public void initialize() {
        Platform.runLater(new Runnable() {
            public void run() {
                display();
            }
        });
    }

    public void setResult(Patient patient, Result result) {
        this.patient = patient;
        this.result = result;
    }

    @FXML
    private void display() {
        patientLabel.setText(patient.getPatientID() + ": " + patient.getFullName());
        resultIDLabel.setText(result.getResultID()+"");
        dateLabel.setText(result.getNoteDate());
        infoLabel.setText(result.getResultInfo());
        prescriptionLabel.setText(result.getPrescription());
    }

}