package models;

public class Result {
    private int resultID;
    private String noteDate;
    private int resultInfo;
    private String prescription;
    private int patientID;
    private int medicID;

    public Result(int resultID, String noteDate, int resultInfo, String prescription, int patientID, int medicID) {
        this.resultID = resultID;
        this.noteDate = noteDate;
        this.resultInfo = resultInfo;
        this.prescription = prescription;
        this.patientID = patientID;
        this.medicID = medicID;
    }
}
