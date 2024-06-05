package com.friend_tracker.friend_tracker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FriendsRepository extends JpaRepository<FriendProfile, Long> {

    FriendProfile getById(long id);

    List<FriendProfile> getAllByName(String name);

    List<FriendProfile> getAllByBirthdayBetween(LocalDate startDate, LocalDate endDate);

    List<FriendProfile> getAllByOccupation(String occupation);

    List<FriendProfile> getAllByHeritage(String allergy);

    List<FriendProfile> getAllByLastSeen(LocalDate lastSeen);

    @Query(value = "SELECT allergies.allergy_name " +
            "FROM profiles p " +
            "JOIN profile_allergy pa ON p.id = pa.profile_id " +
            "JOIN allergies a ON pa.allergy_id = a.id " +
            "WHERE p.id = ?1", nativeQuery = true)
    List<String> getAllProfileAllergies(Long profileId); // when allergy button is clicked on front end

    void deleteProfileById(long id);
}


