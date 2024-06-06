package com.friend_tracker.friend_tracker;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FriendProfileAllergyMappingRepository extends JpaRepository<FriendProfileAllergyMapping, Long> {

//    @Query(value = "SELECT allergies.allergy_name " +
//            "FROM profiles p " +
//            "JOIN profile_allergy pa ON p.id = pa.profile_id " +
//            "JOIN allergies a ON pa.allergy_id = a.id " +
//            "WHERE p.id = ?1", nativeQuery = true)
//    List<String> getAllProfileAllergies(Long profileId); // when allergy button is clicked on front end

    List<FriendProfile> getAllByAllergyId(long id);

    int countAllByAllergyId(long id);

    void deleteAllByAllergyId(long id);
}
