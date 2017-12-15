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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Patient;
import models.Result;

import java.io.IOException;

public class PatientRecordFMRPController {

    @FXML
    private Pane patientRecordFMRPPane;
    @FXML
    private Button backBtn;
    @FXML
    private Button examBtn;

    @FXML
    private TableView<Result> resultTable;
    @FXML
    private TableColumn<Result, Integer> resultIDColumn;
    @FXML
    private TableColumn<Result, String> dateColumn, infoColumn;

    @FXML
    private Label patientLabel;

    private Patient patient;

    @FXML
    public void initialize() {
        Platform.runLater(new Runnable() {
            public void run() {
                patientLabel.setText(patient.getPatientID() + ": " +  patient.getFullName());
                ObservableList<Result> list = FXCollections.observableArrayList();
                for (Result result: patient.getResults()) {
                    list.add(result);
                }
                resultIDColumn.setCellValueFactory(new PropertyValueFactory<Result, Integer>("resultID"));
                dateColumn.setCellValueFactory(new PropertyValueFactory<Result, String>("noteDate"));
                infoColumn.setCellValueFactory(new PropertyValueFactory<Result, String>("resultInfo"));
                resultTable.setItems(list);
            }
        });
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

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

        Stage stage = (Stage) patientRecordFMRPPane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/SymptomPage.fxml"));
        try {
            stage.setScene(new Scene((Parent) loader.load(),650, 500));
            SymptomController controller = loader.getController();
            controller.setPatient(patient);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

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