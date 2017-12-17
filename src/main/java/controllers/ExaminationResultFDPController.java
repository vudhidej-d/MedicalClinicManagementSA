package controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Patient;

import java.io.IOException;

public class ExaminationResultFDPController {

    private Patient patient;
    private DBController db = new DBController();

    @FXML
    private Label infoLabel,dateLabel,prescriptionLabel,resultIDLabel,patientNameLabel;
    @FXML
    private Pane examinationResultPane;

    @FXML
    public void initialize(){
        Platform.runLater(new Runnable() {
            public void run() {
                patientNameLabel.setText("ID: "+Integer.toString(patient.getPatientID())+" NAME: "+patient.getFullName());
                resultIDLabel.setText("Examresult: "+ patient.getCurrentResultID());
                dateLabel.setText(patient.getCurrentResultDate());
                infoLabel.setText(patient.getCurrentResultInfo());
                prescriptionLabel.setText(patient.getResults().get(patient.getResults().size()-1).getPrescription());
            }
        });
    }

    @FXML
    public void cancelBtnHandle() {
        changeScene("/DispensaryPage.fxml", 1000, 800);
    }

    @FXML
    public void completeBtnHandle() {
        db.updateStatus("STANDBY",patient.getPatientID());
        alert("การตรวจเสร็จสิ้น");
        changeScene("/DispensaryPage.fxml", 1000, 800);
    }

    public void setPatient(Patient patient){
        this.patient = patient ;
    }

    public void changeScene(String scene, int w, int h) {
        Stage stage = (Stage) examinationResultPane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(scene));
        try {
            stage.setScene(new Scene((Parent) loader.load(),w, h));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void alert(String message) {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/AlertPopup.fxml"));
        try {
            stage.initOwner(examinationResultPane.getScene().getWindow());
            stage.setScene(new Scene((Parent) loader.load()));
            stage.setTitle("Alert!");
            stage.initModality(Modality.WINDOW_MODAL);

            AlertController controller = loader.getController();
            controller.setStage(stage);
            controller.getPopupLabel().setText(message);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}