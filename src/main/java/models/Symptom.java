package models;

public class Symptom {
    public static int currentID;
    private int symptomID;
    private String noteDate;
    private String symptomInfo;
    private int patientID;
    private String staffID;

    public Symptom(String noteDate, String symptomInfo, int patientID, String staffID) {
        this.symptomID = currentID;
        this.noteDate = noteDate;
        this.symptomInfo = symptomInfo;
        this.patientID = patientID;
        this.staffID = staffID;
        currentID++;
    }

    public Symptom(int symptomID, String noteDate, String symptomInfo, int patientID, String staffID) {
        this.symptomID = symptomID;
        this.noteDate = noteDate;
        this.symptomInfo = symptomInfo;
        this.patientID = patientID;
        this.staffID = staffID;
    }
}
