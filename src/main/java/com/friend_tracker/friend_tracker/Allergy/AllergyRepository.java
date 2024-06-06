package com.friend_tracker.friend_tracker.Allergy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AllergyRepository extends JpaRepository<Allergy, Long> {

    List<Allergy> getAllByAllergyName(String name);

    List<Allergy> getAllBySymptomsContaining(String symptom);

    void deleteAllergyById(long id);
}
