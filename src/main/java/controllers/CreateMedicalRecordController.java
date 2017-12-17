package controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Patient;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CreateMedicalRecordController {

    private DBController db = new DBController();

    @FXML
    private TextField nationalIDTF;
    @FXML
    private TextField firstNameTF;
    @FXML
    private TextField lastNameTF;
    @FXML
    private ComboBox<String> sexCB;
    @FXML
    private DatePicker dateOfBirthDP;
    @FXML
    private TextField ageTF;
    @FXML
    private ComboBox<String> bloodGroupCB;
    @FXML
    private TextField nationalityTF;
    @FXML
    private TextField religionTF;
    @FXML
    private TextField telTF;
    @FXML
    private TextArea intoleranceTF;
    @FXML
    private Pane createMedicalRecordPane;

    @FXML
    public void initialize() {
        dateOfBirthDP.setValue(LocalDate.now());
        sexCB.setItems(FXCollections.observableArrayList("MALE", "FEMALE"));
        bloodGroupCB.setItems(FXCollections.observableArrayList("A", "B", "O", "AB"));
    }

    @FXML
    public void cancelBtnHandle() {
        changeScene("/MedicalRecordsPage.fxml", 1000, 800);
    }

    @FXML
    public void submitBtnHandle()  {
        String nationalID = nationalIDTF.getText();
        String firstName = firstNameTF.getText();
        String lastName = lastNameTF.getText();
        String sex = sexCB.getValue();
        System.out.println(sex);
        String dateOfBirth = dateOfBirthDP.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println(dateOfBirth);
        String age = ageTF.getText();
        String bloodGroup = bloodGroupCB.getValue();
        System.out.println(bloodGroup);
        String nationality = nationalityTF.getText();
        String religion = religionTF.getText();
        String telNumber = telTF.getText();
        String[] intolerances = intoleranceTF.getText().split("\n");
        boolean isNotNull = nationalID != null && firstName != null && lastName != null && sex != null &&
                dateOfBirth != null && age != null && bloodGroup != null && nationality != null &&
                religion != null && telNumber != null && intolerances != null;
        boolean isNumeric = nationalID.matches("[+]?\\d*\\.?\\d+") &&
                age.matches("[+]?\\d*\\.?\\d+") &&
                telNumber.matches("[+]?\\d*\\.?\\d+");
        if (isNotNull && isNumeric && nationalID.length() == 13 && (telNumber.length() == 10 || telNumber.length() == 9)) {
            db.insertPatientRecord(new Patient(nationalID, firstName, lastName, sex, dateOfBirth, age, bloodGroup,
                    nationality, religion, telNumber, intolerances));
            alert("สร้างระเบียนประวัติผู้ป่วยเรียบร้อย");
            changeScene("/MedicalRecordsPage.fxml", 1000, 800);
        } else {
            alert("ข้อมูลไม่สมบูรณ์");
        }
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

    public void alert(String message) {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/AlertPopup.fxml"));
        try {
            stage.initOwner(createMedicalRecordPane.getScene().getWindow());
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