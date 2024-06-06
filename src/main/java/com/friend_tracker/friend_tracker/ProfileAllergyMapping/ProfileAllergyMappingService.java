package com.friend_tracker.friend_tracker.ProfileAllergyMapping;

import com.friend_tracker.friend_tracker.FriendNotFoundException;
import com.friend_tracker.friend_tracker.Profile.Profile;
import com.friend_tracker.friend_tracker.Profile.ProfileRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProfileAllergyMappingService {

    @Autowired
    ProfileAllergyMappingRepository profileAllergyMappingRepository;

    @Autowired
    ProfileRepository profileRepository;


    // CREATE
    public void addProfileAllergyRelationship(ProfileAllergyMapping profileAllergy) {
        profileAllergyMappingRepository.save(profileAllergy);
    }


    // READ
    public List<String> getProfileAllergies(long id) {
       return profileAllergyMappingRepository.getAllProfileAllergies(id);
    }

    public List<Profile> getProfilesByAllergyId(long allergyId) {
        List<ProfileAllergyMapping> profileAllergyMapping = profileAllergyMappingRepository.getAllByAllergyId(allergyId);

        List<Long> profileIds = profileAllergyMapping
                .stream()
                .map(ProfileAllergyMapping::getProfileId)
                .toList();

        return profileRepository.findAllById(profileIds);
    }

    public List<Profile> getAllProfilesWithAllergies() {
        List<ProfileAllergyMapping> profileAllergyMapping = profileAllergyMappingRepository.findAll();

        Set<Long> profileIds = profileAllergyMapping
                .stream()
                .map(ProfileAllergyMapping::getProfileId)
                .collect(Collectors.toSet());

        return profileRepository.findAllById(profileIds);
    }

    // UPDATE
    @Transactional
    public void updateProfileAllergyRelationship(ProfileAllergyMapping newRelationship, long id) {
        if (!profileAllergyMappingRepository.existsById(id)) {
            throw new FriendNotFoundException("Profile - Allergy relationship not found: Unable to update allergy for this Profile");
        }

        newRelationship.setId(id);
        profileAllergyMappingRepository.save(newRelationship);
    }


    // DELETE
    @Transactional
    public void deleteProfileAllergyRelationship(long id) {
        if (!profileAllergyMappingRepository.existsById(id)) {
            throw new FriendNotFoundException("Profile - Allergy relationship not found: Unable to delete allergy for this Profile");
        }

        profileAllergyMappingRepository.deleteById(id);
    }
}
