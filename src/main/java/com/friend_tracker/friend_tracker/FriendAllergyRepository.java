package com.friend_tracker.friend_tracker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendAllergyRepository extends JpaRepository<FriendAllergy, Long> {

    List<FriendAllergy> getAllByAllergyName(String name);

    List<FriendAllergy> getAllBySymptomsContaining(String symptom);

    void deleteAllergyById(long id);
}
