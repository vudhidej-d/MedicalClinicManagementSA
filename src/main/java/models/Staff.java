package models;

import java.util.ArrayList;

public class Staff {
    private int staffID;
    private String firstName;
    private String lastName;
    private Role role;
    private String dateOfBirth;
    private String age;
    private String telNumber;

    private ArrayList<Symptom> symptoms;

    public Staff(int staffID, String firstName, String lastName, Role role, String dateOfBirth, String age, String telNumber) {
        this.staffID = staffID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.telNumber = telNumber;
    }

    private enum Role {
        MEDICAL_ASSISTANT, DISPENSER
    }
}