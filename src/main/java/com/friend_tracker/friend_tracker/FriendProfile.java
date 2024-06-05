package com.friend_tracker.friend_tracker;

import jakarta.persistence.*;

@Entity
@Table(name = "profile")
public class FriendProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String birthdayStr;
    private String numOfSiblingsStr;
    private String occupation;
    private String heritage;
    private String lastSeenStr;



    public FriendProfile() {

    }

    public FriendProfile(long id, String name, String birthdayStr, String numOfSiblingsStr, String occupation, String heritage, String lastSeenStr) {
        this.id = id;
        this.name = name;
        this.birthdayStr = birthdayStr;
        this.numOfSiblingsStr = numOfSiblingsStr;
        this.occupation = occupation;
        this.lastSeenStr = lastSeenStr;
        this.heritage = heritage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdayStr() {
        return birthdayStr;
    }

    public void setBirthdayStr(String birthdayStr) {
        this.birthdayStr = birthdayStr;
    }

    public String getNumOfSiblingsStr() {
        return numOfSiblingsStr;
    }

    public void setNumOfSiblingsStr(String numOfSiblingsStr) {
        this.numOfSiblingsStr = numOfSiblingsStr;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getLastSeenStr() {
        return lastSeenStr;
    }

    public void setLastSeenStr(String lastSeenStr) {
        this.lastSeenStr = lastSeenStr;
    }

    public String getHeritage() {
        return heritage;
    }

    public void setHeritage(String heritage) {
        this.heritage = heritage;
    }
}
