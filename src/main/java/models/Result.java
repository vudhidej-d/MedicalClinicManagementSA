package models;

public class Result {
    public static int currentID;
    private int resultID;
    private String noteDate;
    private String resultInfo;
    private String prescription;
    private int patientID;
    private int medicID;

    public Result(String noteDate, String resultInfo, String prescription, int patientID, int medicID) {
        this.resultID = currentID;
        this.noteDate = noteDate;
        this.resultInfo = resultInfo;
        this.prescription = prescription;
        this.patientID = patientID;
        this.medicID = medicID;
        currentID++;
    }

    public Result(int resultID, String noteDate, String resultInfo, String prescription, int patientID, int medicID) {
        this.resultID = resultID;
        this.noteDate = noteDate;
        this.resultInfo = resultInfo;
        this.prescription = prescription;
        this.patientID = patientID;
        this.medicID = medicID;
    }

    public int getResultID() {
        return resultID;
    }

    public String getNoteDate() {
        return noteDate;
    }

    public String getResultInfo() {
        return resultInfo;
    }

    public String getPrescription() {
        return prescription;
    }

    public int getPatientID() {
        return patientID;
    }

    public int getMedicID() {
        return medicID;
    }
}