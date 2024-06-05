package com.friend_tracker.friend_tracker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendsRepository extends JpaRepository<FriendProfile, Long> {
//   List<Profile> getAllByBirthday

    List<FriendProfile> getAllByHeritage(String allergy);

    @Query(value="SELECT DISTINCT id FROM profiles ", nativeQuery = true)
    List<Long> getDistinctIds();

    @Query(value = "SELECT allergies.allergy_name " +
            "FROM profiles p " +
            "JOIN profile_allergy pa ON p.id = pa.profile_id " +
            "JOIN allergies a ON pa.allergy_id = a.id " +
            "WHERE p.id = ?1", nativeQuery = true)
    List<String> getProfileAllergies(Long profileId); // when allergy button is clicked on front end

}


