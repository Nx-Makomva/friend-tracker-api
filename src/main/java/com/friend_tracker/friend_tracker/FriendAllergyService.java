package com.friend_tracker.friend_tracker;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FriendAllergyService {

    @Autowired
    FriendAllergyRepository friendAllergyRepository;

    // CREATE

    public void addAllergy(FriendAllergy allergy) {
        friendAllergyRepository.save(allergy);
    }

    // READ
    public FriendAllergy getAllergyById(long id) {
        Optional<FriendAllergy> allergy = friendAllergyRepository.findById(id);

        if (allergy.isEmpty()) {
            throw new FriendNotFoundException("Allergy could not be found");
        }

        return allergy.get();
    }

    public List<FriendAllergy> getAllAllergies(int limit) {
        return friendAllergyRepository
                .findAll()
                .stream()
                .limit(limit)
                .sorted(Comparator.comparing(FriendAllergy::getAllergyName))
                .collect(Collectors.toList());
    }

    public List<FriendAllergy> getByAllergyName(String allergy, int limit) {
        List<FriendAllergy> allergies = friendAllergyRepository.getAllByAllergyName(allergy);

        return allergies
                .stream()
                .limit(limit)
                .collect(Collectors.toList());

    }

    public List<FriendAllergy> getBySymptoms(String symptom) {
        return friendAllergyRepository.getAllBySymptomsContaining(symptom);
    }


    // UPDATE

    @Transactional
    public void updateAllergy(FriendAllergy newAllergy, long id) {
        if (!friendAllergyRepository.existsById(id)) {
            throw new FriendNotFoundException("Allergy not found: Cannot update Allergy.");
        }

        newAllergy.setId(id);
        friendAllergyRepository.save(newAllergy);
    }

    // DELETE

    @Transactional
    public void deleteAllergy(long id) {
        if (!friendAllergyRepository.existsById(id)) {
            throw new FriendNotFoundException("Allergy not found: Cannot delete Allergy.");
        }

        friendAllergyRepository.deleteAllergyById(id);
    }

}
