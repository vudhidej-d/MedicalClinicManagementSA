package controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.Patient;
import models.Result;

import java.io.IOException;

public class ExaminationController {

    private DBController db = new DBController();
    private Patient patient;

    @FXML
    private Pane examinationPane;
    @FXML
    private Label patientLabel;
    @FXML
    private TextField dateField;
    @FXML
    private TextArea infoArea;
    @FXML
    private TextArea prescriptionArea;

    @FXML
    public void initialize() {
        Platform.runLater(new Runnable() {
            public void run() {
                patientLabel.setText(patient.getPatientID() + ": " + patient.getFullName());
            }
        });
    }

    @FXML
    public void cancelBtnHandle() {
        Stage stage = (Stage) examinationPane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/PatientRecordPageFERP.fxml"));
        try {
            stage.setScene(new Scene((Parent) loader.load(),1000, 800));
            PatientRecordFERPController controller = loader.getController();
            controller.setPatient(patient);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void submitBtnHandle()  {
        db.insertResult(new Result(dateField.getText(), infoArea.getText(), prescriptionArea.getText(), patient.getPatientID(), db.selectMedicID(Integer.parseInt(ExaminationRoomController.roomNum))));
        db.updateStatus("DISPENSARY", patient.getPatientID());
        changeScene("/ExaminationRoomPage.fxml", 1000, 800);
    }

    public void changeScene(String scene, int w, int h) {
        Stage stage = (Stage) examinationPane.getScene().getWindow();
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