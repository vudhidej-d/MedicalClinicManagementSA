package models;

public class Symptom {
    private String symptomID;
    private String noteDate;
    private String symptomInfo;
    private String patientID;
    private String staffID;

    public Symptom(String symptomID, String noteDate, String symptomInfo, String patientID, String staffID) {
        this.symptomID = symptomID;
        this.noteDate = noteDate;
        this.symptomInfo = symptomInfo;
        this.patientID = patientID;
        this.staffID = staffID;
    }
}
