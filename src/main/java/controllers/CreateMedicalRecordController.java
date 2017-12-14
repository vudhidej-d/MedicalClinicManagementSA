package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.BloodGroup;
import models.Patient;
import models.Sex;

import java.io.IOException;

public class CreateMedicalRecordController {

    DBController db = new DBController();

    @FXML
    TextField nationalIDTF;
    @FXML
    TextField firstNameTF;
    @FXML
    TextField lastNameTF;
    @FXML
    TextField sexTF;
    @FXML
    TextField dateOfBirthTF;
    @FXML
    TextField ageTF;
    @FXML
    TextField bloodGroupTF;
    @FXML
    TextField nationalityTF;
    @FXML
    TextField religionTF;
    @FXML
    TextField telTF;
    @FXML
    TextArea intoleranceTF;
    @FXML
    private Pane createMedicalRecordPane;
//    @FXML
//    private Button submitBtn;
//    @FXML
//    private Button cancelBtn;

    @FXML
    public void cancelBtnHandle() {
        changeScene("/MedicalRecordsPage.fxml", 1000, 800);
    }

    @FXML
    public void submitBtnHandle()  {
        String nationalID = nationalIDTF.getText();
        String firstName = firstNameTF.getText();
        String lastName = lastNameTF.getText();
        String sex = sexTF.getText().toUpperCase();
        System.out.println(sex);
        String dateOfBirth = dateOfBirthTF.getText();
        String age = ageTF.getText();
        String bloodGroup = bloodGroupTF.getText().toUpperCase();
        System.out.println(bloodGroup);
        String nationality = nationalIDTF.getText();
        String religion = religionTF.getText();
        String telNumber = telTF.getText();
        String[] intolerances = intoleranceTF.getText().split("\n");
        db.insertPatientRecord(new Patient(nationalID, firstName, lastName, sex, dateOfBirth, age, bloodGroup,
                nationality, religion, telNumber, intolerances));
        changeScene("/MedicalRecordsPage.fxml", 1000, 800);
    }

    public void changeScene(String scene, int w, int h) {
        Stage stage = (Stage) createMedicalRecordPane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(scene));
        try {
            stage.setScene(new Scene((Parent) loader.load(),w, h));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
