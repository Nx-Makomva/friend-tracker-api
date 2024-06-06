package com.friend_tracker.friend_tracker.ProfileAllergyMapping;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProfileAllergyMappingRepository extends JpaRepository<ProfileAllergyMapping, Long> {

    @Query(value = "SELECT allergies.allergy_name " +
            "FROM profiles p " +
            "JOIN profile_allergy pa ON p.id = pa.profile_id " +
            "JOIN allergies a ON pa.allergy_id = a.id " +
            "WHERE p.id = ?1", nativeQuery = true)
    List<String> getAllProfileAllergies(long profileId); // when allergy button is clicked on front end

    List<ProfileAllergyMapping> getAllByAllergyId(long id);

    void deleteById(long id);
}
