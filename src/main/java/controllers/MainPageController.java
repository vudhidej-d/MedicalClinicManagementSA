package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Patient;
import models.Result;
import models.Symptom;

import java.io.IOException;

public class MainPageController {

    private DBController db = new DBController();

    @FXML
    private Pane mainPane;
    @FXML
    private TextField roomNumField;

    @FXML
    public void initialize() {
        Patient.currentID = db.getLastID("Patient")+1;
        Symptom.currentID = db.getLastID("Symptom")+1;
        Result.currentID = db.getLastID("Result")+1;
    }

    @FXML
    public void medicalRecordsBtnHandle() {
        changeScene("/MedicalRecordsPage.fxml", 1000, 800);
    }

    @FXML
    public void examinationRoomBtnHandle() {
        if (check()) {
            Stage stage = (Stage) mainPane.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ExaminationRoomPage.fxml"));
            try {
                stage.setScene(new Scene((Parent) loader.load(), 1000, 800));
                ExaminationRoomController controller = loader.getController();
                controller.setRoomNum(roomNumField.getText());
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            alert("ไม่มีห้องหมายเลข "+roomNumField.getText()+" อยู่");
        }
    }

    @FXML
    public void dispensaryBtnHandle() {
        changeScene("/DispensaryPage.fxml", 1000, 800);
    }

    public void changeScene(String scene, int w, int h) {
        Stage stage = (Stage) mainPane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(scene));
        try {
            stage.setScene(new Scene((Parent) loader.load(),w, h));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean check() {
        if (!roomNumField.getText().isEmpty()) {
            for (int i: db.selectAllRoomNumber()) {
                if (i == Integer.parseInt(roomNumField.getText())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void alert(String message) {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/AlertPopup.fxml"));
        try {
            stage.initOwner(mainPane.getScene().getWindow());
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