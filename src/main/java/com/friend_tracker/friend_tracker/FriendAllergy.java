package com.friend_tracker.friend_tracker;

import jakarta.persistence.*;

@Entity
@Table(name = "allergies")
public class FriendAllergy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String allergyName;
    private String symptoms;
    private String precautions;
    private String treatment;

    public FriendAllergy() {
    }

    public FriendAllergy(long id, long profileId, String allergyName, String symptoms, String precautions, String treatment) {
        this.id = id;
        this.allergyName = allergyName;
        this.symptoms = symptoms;
        this.precautions = precautions;
        this.treatment = treatment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAllergyName() {
        return allergyName;
    }

    public void setAllergyName(String allergyName) {
        this.allergyName = allergyName;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getPrecautions() {
        return precautions;
    }

    public void setPrecautions(String precautions) {
        this.precautions = precautions;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }
}
