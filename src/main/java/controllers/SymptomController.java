package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class SymptomController {

    @FXML
    private Pane symtomPane;
    @FXML
    private Button backBtn;
    @FXML
    private Button submitBtn;

    @FXML
    public void backBtnHandle() { changeScene("/PatientRecordFMRP.fxml", 1000, 800); }

    @FXML
    public void submitBtnHandle()  {
        changeScene("/MedicalRecordsPage.fxml", 1000, 800);
    }

    public void changeScene(String scene, int w, int h) {
        Stage stage = (Stage) symtomPane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(scene));
        try {
            stage.setScene(new Scene((Parent) loader.load(),w, h));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}