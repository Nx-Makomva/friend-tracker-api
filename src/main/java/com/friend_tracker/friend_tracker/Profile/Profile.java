package com.friend_tracker.friend_tracker.Profile;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private LocalDate birthday;
    private int numOfSiblings;
    private String occupation;
    private String heritage;
    private LocalDate lastSeen;



    public Profile() {

    }

    public Profile(long id, String name, LocalDate birthday, int numOfSiblings, String occupation, String heritage, LocalDate lastSeen) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.numOfSiblings = numOfSiblings;
        this.occupation = occupation;
        this.lastSeen = lastSeen;
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getNumOfSiblings() {
        return numOfSiblings;
    }

    public void setNumOfSiblings(int numOfSiblings) {
        this.numOfSiblings = numOfSiblings;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public LocalDate getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(LocalDate lastSeen) {
        this.lastSeen = lastSeen;
    }

    public String getHeritage() {
        return heritage;
    }

    public void setHeritage(String heritage) {
        this.heritage = heritage;
    }
}
