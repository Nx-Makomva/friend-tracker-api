package com.friend_tracker.friend_tracker;

import jakarta.persistence.*;

@Entity
@Table(name = "profile_allergy_mapping")
public class FriendProfileAllergyMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long profileId;
    private long allergyId;

    public FriendProfileAllergyMapping(){

    }

    public FriendProfileAllergyMapping(long id, long profileId, long allergyId) {
        this.id = id;
        this.profileId = profileId;
        this.allergyId = allergyId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProfileId() {
        return profileId;
    }

    public void setProfileId(long profileId) {
        this.profileId = profileId;
    }

    public long getAllergyId() {
        return allergyId;
    }

    public void setAllergyId(long allergyId) {
        this.allergyId = allergyId;
    }
}
