package models;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;

public class Patient {
    public static int currentID;
    private int patientID;
    private String nationalID;
    private String firstName;
    private String lastName;
    private String fullName;
    private Sex sex;
    private String dateOfBirth;
    private String age;
    private BloodGroup bloodGroup;
    private String nationality;
    private String religion;
    private String telNumber;
    private String[] intolerances;
    private String currentSymptom;
    private int currentResultID;
    private String currentResultInfo;
    private String currentResultDate;

    public int getCurrentResultID() {
        return currentResultID;
    }

    public String getCurrentResultInfo() {
        return currentResultInfo;
    }

    public String getCurrentResultDate() {
        return currentResultDate;
    }

    private ArrayList<Result> results = new ArrayList<Result>();
    private ArrayList<Symptom> symptoms = new ArrayList<Symptom>();

    public Patient(String nationalID, String firstName, String lastName, String sex, String dateOfBirth,
                   String age, String bloodGroup, String nationality, String religion, String telNumber, String[] intolerances) {
        this.patientID = currentID;
        this.nationalID = nationalID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName+" "+lastName;
        if (sex.equalsIgnoreCase("MALE")) {
            this.sex = Sex.MALE;
        } else {
            this.sex = Sex.FEMALE;
        }
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        if (bloodGroup.equalsIgnoreCase("A")) {
            this.bloodGroup = BloodGroup.A;
        } else if (bloodGroup.equalsIgnoreCase("B")) {
            this.bloodGroup = BloodGroup.B;
        } else if (bloodGroup.equalsIgnoreCase("O")) {
            this.bloodGroup = BloodGroup.O;
        } else {
            this.bloodGroup = BloodGroup.AB;
        }
        this.nationality = nationality;
        this.religion = religion;
        this.telNumber = telNumber;
        this.intolerances = intolerances;
        currentID++;
    }

    public Patient(int patientID, String nationalID, String firstName, String lastName, String sex, String dateOfBirth,
                   String age, String bloodGroup, String nationality, String religion, String telNumber, String[] intolerances) {
        this.patientID = patientID;
        this.nationalID = nationalID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName+" "+lastName;
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

    public void setCurrentSymptom() {
        System.out.println(symptoms.size());
        currentSymptom = symptoms.get(symptoms.size() - 1).getSymptomInfo();
    }

    public void setSymptoms(ArrayList<Symptom> symptoms) {
        this.symptoms = symptoms;
    }

    public void addSymptom(Symptom symptom) {
        symptoms.add(symptom);
    }

    public String getCurrentSymptom() {
        return currentSymptom;
    }

    public int getPatientID() {
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

    public String getFullName() {
        return fullName;
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

    public void setResult(ArrayList<Result> results){
        this.results=results;
        this.currentResultID=results.get(results.size()-1).getResultID();
        this.currentResultInfo=results.get(results.size()-1).getResultInfo();
        this.currentResultDate=results.get(results.size()-1).getNoteDate();

    }
    public ArrayList<Result> getResults() {
        return results;
    }

    public ArrayList<Symptom> getSymptoms() { return symptoms; }


}
