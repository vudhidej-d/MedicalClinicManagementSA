package controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Patient;
import models.Result;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ExaminationController {

    private DBController db = new DBController();
    private Patient patient;

    @FXML
    private Pane examinationPane;
    @FXML
    private Label patientLabel;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextArea infoArea;
    @FXML
    private TextArea prescriptionArea;

    @FXML
    public void initialize() {
        Platform.runLater(new Runnable() {
            public void run() {
                datePicker.setValue(LocalDate.now());
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
        if (check()) {
            db.insertResult(new Result(datePicker.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yy")), infoArea.getText(), prescriptionArea.getText(), patient.getPatientID(), db.selectMedicID(Integer.parseInt(ExaminationRoomController.roomNum))));
            db.updateStatus("DISPENSARY", patient.getPatientID());
            alert("บันทึกผลการตรวจเรียบร้อย");
            changeScene("/ExaminationRoomPage.fxml", 1000, 800);
        } else {
            alert("ข้อมูลไม่สมบูรณ์");
        }
    }

    private boolean check() {
        if (datePicker.getValue() != null && !infoArea.getText().isEmpty() && !prescriptionArea.getText().isEmpty()) {
            return true;
        }
        return false;
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

    public void alert(String message) {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/AlertPopup.fxml"));
        try {
            stage.initOwner(examinationPane.getScene().getWindow());
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