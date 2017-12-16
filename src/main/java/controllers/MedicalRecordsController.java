package controllers;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.Patient;

import java.io.IOException;
import java.util.ArrayList;

public class MedicalRecordsController {

    private DBController db = new DBController();
    private ArrayList<Patient> patientRecords = new ArrayList<Patient>();
//    private ObservableList<Patient> list = FXCollections.observableArrayList();

    @FXML
    private Pane medicalRecordsPane;
    @FXML
    private TableView<Patient> medicalRecordsTable;
    @FXML
    private TableColumn<Patient, Integer> patientIDColumn;
    @FXML
    private TableColumn<Patient, String> nameColumn, telColumn;
    @FXML
    private TextField searchTF;
    @FXML
    private Button backBtn;
    @FXML
    private Button createBtn;
    @FXML
    private Button searchBtn;

    @FXML
    public void initialize() {
        patientRecords = db.selectPatientRecords();
        updateTable();

        medicalRecordsTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                onClickedPatientRecord();
            }
        });
    }

    @FXML
    public void backBtnHandle() {
        changeScene("/MainPage.fxml", 600, 500);
    }

    @FXML
    public void searchBtnHandle() {
        String name = searchTF.getText();
        if (name.equals("")) {
            patientRecords = db.selectPatientRecords();
        } else {
            patientRecords = db.searchPatient(name);
        }
        updateTable();
    }

    @FXML
    public void createBtnHandle()  {
        changeScene("/CreateMedicalRecordPage.fxml", 650, 400);
    }

    public void changeScene(String scene, int w, int h) {
        Stage stage = (Stage) medicalRecordsPane.getScene().getWindow();
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
//        patientRecords = db.selectPatientRecords();
        for (int i = 0; i < patientRecords.size(); i++) {
            list.add(patientRecords.get(i));
            System.out.println(patientRecords.get(i).getFullName());
        }
        patientIDColumn.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("patientID"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("fullName"));
        telColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("telNumber"));

        medicalRecordsTable.setItems(list);
    }

    private void onClickedPatientRecord() {
        ObservableList<Patient> patientSelected, allPatients;
        allPatients = medicalRecordsTable.getItems();
        patientSelected = medicalRecordsTable.getSelectionModel().getSelectedItems();
        Stage stage = (Stage) medicalRecordsPane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/PatientRecordPageFMRP.fxml"));
        try {
            if(!patientSelected.isEmpty()) {
                stage.setScene(new Scene((Parent) loader.load(), 1000, 800));
                PatientRecordFMRPController controller = loader.getController();
                controller.setPatient(patientRecords.get(allPatients.indexOf(patientSelected.get(0))));
                stage.show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}