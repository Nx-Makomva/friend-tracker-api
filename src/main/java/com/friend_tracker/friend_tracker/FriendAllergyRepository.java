package com.friend_tracker.friend_tracker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendAllergyRepository extends JpaRepository<FriendAllergy, Long> {

    FriendAllergy getById(long id);

    List<FriendAllergy> getAllByName(String name);

    List<FriendAllergy> getAllByOrderByNameAsc();

    List<FriendAllergy> getAllBySymptomsContaining(String symptom);

    int countAll();

    void deleteAllergyById(long id);
}
