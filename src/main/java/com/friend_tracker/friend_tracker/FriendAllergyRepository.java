package com.friend_tracker.friend_tracker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendAllergyRepository extends JpaRepository<FriendAllergy, Long> {

    FriendAllergy getById(long id);

    List<FriendAllergy> getAllByAllergyName(String name);

    List<FriendAllergy> getAllByOrderByAllergyNameAsc();

    List<FriendAllergy> getAllBySymptomsContaining(String symptom);

    // int countAll(); // - spring couldn't figure this one out and so did not auto create it

    void deleteAllergyById(long id);
}
