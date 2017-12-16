package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.Patient;
import models.Result;

import java.io.IOException;
import java.util.ArrayList;

public class DispensaryController {
//
//    public static void main(String[] args) {
//        ArrayList<String> str = new ArrayList<String>();
//        str.add("a");
//        str.add("b");
//        System.out.println(str.get(-1));
//    }
    private DBController db = new DBController();
    private ArrayList<Patient> patientRecords = new ArrayList<Patient>();

    @FXML
    private TableColumn<Patient, Integer> resultIDColumn,patientIDColumn;

    @FXML
    private TableColumn<Patient, String> dateColumn, infoColumn,patientNameColumn;

    @FXML
    private Pane dispensaryPane;

    @FXML
    private TableView<Patient> dispensaryTable;



    @FXML
    public void initialize(){
        patientRecords = db.selectPatientRecords("DISPENSARY");
        updateTable();
        dispensaryTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                onClickedPatientRecord();
            }
        });

    }


    public void backBttHandle(){changeScene("/MainPage.fxml",600,500);}

    private void onClickedPatientRecord() {
        ObservableList<Patient> patientSelected, allPatients;
        allPatients = dispensaryTable.getItems();
        patientSelected = dispensaryTable.getSelectionModel().getSelectedItems();
        Stage stage = (Stage) dispensaryPane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ExaminationResultPageFDP.fxml"));
        try {
            if(!patientSelected.isEmpty()) {
                stage.setScene(new Scene((Parent) loader.load(), 1000, 800));
                ExaminationResultFDPController controller = loader.getController();
                controller.setPatient(patientRecords.get(allPatients.indexOf(patientSelected.get(0))));

                stage.show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateTable() {
        ObservableList<Patient> list = FXCollections.observableArrayList();
//        patientRecords = db.selectPatientRecords();
        for (int i = 0; i < patientRecords.size(); i++) {

            ArrayList<Result> results =db.selectResults(patientRecords.get(i).getPatientID());
            patientRecords.get(i).setResult(results);
            list.add(patientRecords.get(i));

//            System.out.println(patientRecords.get(i).getFullName());

        }
        patientIDColumn.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("patientID"));

        patientNameColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("fullName"));
        infoColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("currentResultInfo"));
        resultIDColumn.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("currentResultID"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("currentResultDate"));

        dispensaryTable.setItems(list);
    }
    public void changeScene(String scene, int w, int h) {
        Stage stage = (Stage) dispensaryPane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(scene));
        try {
            stage.setScene(new Scene((Parent) loader.load(),w, h));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}