package controllers;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.Patient;

import java.io.IOException;
import java.util.ArrayList;

public class ExaminationRoomController {
    public static String roomNum;

    private DBController db = new DBController();
    private ArrayList<Patient> patientRecords = new ArrayList<Patient>();

    @FXML
    private Pane examinationRoomPane;
    @FXML
    private Label roomNumLabel;
    @FXML
    private TableView<Patient> examinationRoomTable;
    @FXML
    private TableColumn<Patient, Integer> patientIDColumn;
    @FXML
    private TableColumn<Patient, String> fullNameColumn;
    @FXML
    private TableColumn<Patient, String> currentSymptomColumn;

    @FXML
    public void initialize() {
        Platform.runLater(new Runnable() {
            public void run() {
                roomNumLabel.setText(roomNum);
                updateTable();
            }
        });
        examinationRoomTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                onClickedPatientRecord();
            }
        });
    }

    @FXML
    public void backBtnHandle() {
        changeScene("/MainPage.fxml", 600, 500);
    }

    public void changeScene(String scene, int w, int h) {
        Stage stage = (Stage) examinationRoomPane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(scene));
        try {
            stage.setScene(new Scene((Parent) loader.load(),w, h));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateTable() {
        ObservableList<Patient> list = FXCollections.observableArrayList();
        patientRecords = db.selectPatientRecords(roomNum);
        for (int i = 0; i < patientRecords.size(); i++) {
            Patient patient = patientRecords.get(i);
            patient.setSymptoms(db.selectSymptoms(patient.getPatientID()));
            patient.setCurrentSymptom();
            list.add(patient);
            System.out.println(patient.getFullName());
        }
        patientIDColumn.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("patientID"));
        fullNameColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("fullName"));
        currentSymptomColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("currentSymptom"));
        examinationRoomTable.setItems(list);
    }

    private void onClickedPatientRecord() {
        ObservableList<Patient> patientSelected, allPatients;
        allPatients = examinationRoomTable.getItems();
        patientSelected = examinationRoomTable.getSelectionModel().getSelectedItems();
        Stage stage = (Stage) examinationRoomPane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/PatientRecordPageFERP.fxml"));
        try {
            stage.setScene(new Scene((Parent) loader.load(),1000, 800));
            PatientRecordFERPController controller = loader.getController();
            controller.setPatient(patientRecords.get(allPatients.indexOf(patientSelected.get(0))));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }
}