package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
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
    private Button backBtn;
    @FXML
    private Button createBtn;
    @FXML
    private Button searchBtn;

    @FXML
    public void initialize() {
        ObservableList<Patient> list = FXCollections.observableArrayList();
        patientRecords = db.selectPatientRecords();
        for (int i = 0; i < patientRecords.size(); i++) {
            list.add(patientRecords.get(i));
            System.out.println(patientRecords.get(i).getFullName());
        }
        patientIDColumn.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("patientID"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("fullName"));
        telColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("telNumber"));

        medicalRecordsTable.setItems(list);
    }

    @FXML
    public void backBtnHandle() {
        changeScene("/MainPage.fxml", 600, 500);
    }

    @FXML
    public void searchBtnHandle() {

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
}