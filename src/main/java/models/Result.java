package models;

public class Result {
    private String resultID;
    private String noteDate;
    private String resultInfo;
    private String prescription;
    private String patientID;
    private String medicID;

    public Result(String resultID, String noteDate, String resultInfo, String prescription, String patientID, String medicID) {
        this.resultID = resultID;
        this.noteDate = noteDate;
        this.resultInfo = resultInfo;
        this.prescription = prescription;
        this.patientID = patientID;
        this.medicID = medicID;
    }
}
