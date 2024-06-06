package com.friend_tracker.friend_tracker.Profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

    List<Profile> getAllByName(String name);

    List<Profile> getAllByBirthdayBetween(LocalDate startDate, LocalDate endDate);

    List<Profile> getAllByOccupation(String occupation);

    List<Profile> getAllByHeritage(String heritage);

    List<Profile> getAllByLastSeenBetween(LocalDate startDate, LocalDate endDate);

    void deleteProfileById(long id);
}


