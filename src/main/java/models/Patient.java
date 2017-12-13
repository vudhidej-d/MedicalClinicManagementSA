package models;

import java.util.ArrayList;

public class Patient {
    private String patientID;
    private String NationalID;
    private String firstName;
    private String lastName;
    private Sex sex;
    private String dateOfBirth;
    private String age;
    private BloodGroup bloodGroup;
    private String nationality;
    private String religion;
    private String telNumber;
    private String[] Intolerances;

    private ArrayList<Result> results;
    private ArrayList<Symptom> symptoms;

    public Patient(String patientID, String nationalID, String firstName, String lastName, Sex sex, String dateOfBirth,
                   String age, BloodGroup bloodGroup, String nationality, String religion, String telNumber, String[] intolerances) {
        this.patientID = patientID;
        NationalID = nationalID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.bloodGroup = bloodGroup;
        this.nationality = nationality;
        this.religion = religion;
        this.telNumber = telNumber;
        Intolerances = intolerances;
    }

    private enum BloodGroup {
        A, B, O, AB
    }

    private enum Sex {
        MALE, FEMALE
    }

}
