package models;

import java.util.ArrayList;

public class Medic {
    private int medicID;
    private String permissionNumber;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String age;
    private String telNumber;
    private int roomNumber;

    private ArrayList<Result> results;

    public Medic(int medicID, String permissionNumber, String firstName, String lastName, String dateOfBirth,
                 String age, String telNumber, int roomNumber) {
        this.medicID = medicID;
        this.permissionNumber = permissionNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.telNumber = telNumber;
        this.roomNumber = roomNumber;
    }
}
