package models;

import java.util.ArrayList;

public class Medic {
    private String medicID;
    private String permissionNumber;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String age;
    private String telNumber;
    private String roomNumber;

    private ArrayList<Result> results;

    public Medic(String medicID, String permissionNumber, String firstName, String lastName, String dateOfBirth,
                 String age, String telNumber, String roomNumber) {
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
