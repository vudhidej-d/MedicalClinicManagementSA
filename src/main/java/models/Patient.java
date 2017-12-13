package models;

import java.util.ArrayList;

public class Patient {
    private String patientID;
    private String nationalID;
    private String firstName;
    private String lastName;
    private Sex sex;
    private String dateOfBirth;
    private String age;
    private BloodGroup bloodGroup;
    private String nationality;
    private String religion;
    private String telNumber;
    private String[] intolerances;

    private ArrayList<Result> results;
    private ArrayList<Symptom> symptoms;

    public Patient(String patientID, String nationalID, String firstName, String lastName, String sex, String dateOfBirth,
                   String age, String bloodGroup, String nationality, String religion, String telNumber, String[] intolerances) {
        this.patientID = patientID;
        this.nationalID = nationalID;
        this.firstName = firstName;
        this.lastName = lastName;
        if (sex.equals("MALE")) {
            this.sex = Sex.MALE;
        } else {
            this.sex = Sex.FEMALE;
        }
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        if (bloodGroup.equals("A")) {
            this.bloodGroup = BloodGroup.A;
        } else if (bloodGroup.equals("B")) {
            this.bloodGroup = BloodGroup.B;
        } else if (bloodGroup.equals("O")) {
            this.bloodGroup = BloodGroup.O;
        } else {
            this.bloodGroup = BloodGroup.AB;
        }
        this.nationality = nationality;
        this.religion = religion;
        this.telNumber = telNumber;
        this.intolerances = intolerances;
    }

    public String getPatientID() {
        return patientID;
    }

    public String getNationalID() {
        return nationalID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Sex getSex() {
        return sex;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAge() {
        return age;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public String getNationality() {
        return nationality;
    }

    public String getReligion() {
        return religion;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public String[] getIntolerances() {
        return intolerances;
    }

    public ArrayList<Result> getResults() {
        return results;
    }

    public ArrayList<Symptom> getSymptoms() {
        return symptoms;
    }
}
