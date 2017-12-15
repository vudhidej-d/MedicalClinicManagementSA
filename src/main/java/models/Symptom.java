package models;

public class Symptom {
    public static int currentID;
    private int symptomID;
    private String noteDate;
    private String symptomInfo;
    private int patientID;
    private int staffID;

    public Symptom(String noteDate, String symptomInfo, int patientID, int staffID) {
        this.symptomID = currentID;
        this.noteDate = noteDate;
        this.symptomInfo = symptomInfo;
        this.patientID = patientID;
        this.staffID = staffID;
        currentID++;
    }

    public Symptom(int symptomID, String noteDate, String symptomInfo, int patientID, int staffID) {
        this.symptomID = symptomID;
        this.noteDate = noteDate;
        this.symptomInfo = symptomInfo;
        this.patientID = patientID;
        this.staffID = staffID;
    }

    public int getSymptomID() {
        return symptomID;
    }

    public String getNoteDate() {
        return noteDate;
    }

    public String getSymptomInfo() {
        return symptomInfo;
    }

    public int getPatientID() {
        return patientID;
    }

    public int getStaffID() {
        return staffID;
    }
}
