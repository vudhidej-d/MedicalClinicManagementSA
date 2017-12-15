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
import javafx.stage.Stage;
import models.Patient;
import models.Result;

import java.io.IOException;

public class PatientRecordFERPController {
    @FXML
    private Pane patientRecordFERPPane;
    @FXML
    private Button backBtn;
    @FXML
    private Button createBtn;

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

    public void setPatient(Patient patient) { this.patient = patient; }

    @FXML
    public void backBtnHandle() {
        Stage stage = (Stage) patientRecordFERPPane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ExaminationRoomPage.fxml"));
        try {
            stage.setScene(new Scene((Parent) loader.load(),1000, 800));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void createBtnHandle()  {
        Stage stage = (Stage) patientRecordFERPPane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ExaminationPage.fxml"));
        try {
            stage.setScene(new Scene((Parent) loader.load(),650, 500));
            ExaminationController controller = loader.getController();
            controller.setPatient(patient);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}