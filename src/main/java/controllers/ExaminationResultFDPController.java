package controllers;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.Patient;
import models.Result;

import java.io.IOException;

public class ExaminationResultFDPController {

    @FXML
    private Label infoLabel,dateLabel,prescriptionLabel,resultIDLabel,patientNameLabel;

    @FXML
    private Pane examinationResultPane;


    private Patient patient;
    private DBController db = new DBController();

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
    public void cancelBtnHandle() { changeScene("/DispensaryPage.fxml", 1000, 800); }

    @FXML
    public void completeBtnHandle() {
        db.updateStatus("STANDBY",patient.getPatientID());
        changeScene("/DispensaryPage.fxml", 1000, 800);
    }


    public void setPatient(Patient patient){this.patient = patient ;
        System.out.println(patient.getFullName()+"ooooocdcheck");}
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
}