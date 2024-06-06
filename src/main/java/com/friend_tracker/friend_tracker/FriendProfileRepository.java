package com.friend_tracker.friend_tracker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FriendProfileRepository extends JpaRepository<FriendProfile, Long> {

    List<FriendProfile> getAllByName(String name);

    List<FriendProfile> getAllByBirthdayBetween(LocalDate startDate, LocalDate endDate);

    List<FriendProfile> getAllByOccupation(String occupation);

    List<FriendProfile> getAllByHeritage(String heritage);

    List<FriendProfile> getAllByLastSeenBetween(LocalDate startDate, LocalDate endDate);

    void deleteProfileById(long id);
}


