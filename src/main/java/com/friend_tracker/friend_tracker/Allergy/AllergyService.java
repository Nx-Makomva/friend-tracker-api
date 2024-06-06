package com.friend_tracker.friend_tracker.Allergy;

import com.friend_tracker.friend_tracker.FriendNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AllergyService {

    @Autowired
    AllergyRepository allergyRepository;

    // CREATE

    public void addAllergy(Allergy allergy) {
        allergyRepository.save(allergy);
    }

    // READ
    public Allergy getAllergyById(long id) {
        Optional<Allergy> allergy = allergyRepository.findById(id);

        if (allergy.isEmpty()) {
            throw new FriendNotFoundException("Allergy could not be found");
        }

        return allergy.get();
    }

    public List<Allergy> getAllAllergies(int limit) {
        return allergyRepository
                .findAll()
                .stream()
                .limit(limit)
                .sorted(Comparator.comparing(Allergy::getAllergyName))
                .collect(Collectors.toList());
    }

    public List<Allergy> getByAllergyName(String allergy, int limit) {
        List<Allergy> allergies = allergyRepository.getAllByAllergyName(allergy);

        return allergies
                .stream()
                .limit(limit)
                .collect(Collectors.toList());

    }

    public List<Allergy> getBySymptoms(String symptom) {
        return allergyRepository.getAllBySymptomsContaining(symptom);
    }


    // UPDATE

    @Transactional
    public void updateAllergy(Allergy newAllergy, long id) {
        if (!allergyRepository.existsById(id)) {
            throw new FriendNotFoundException("Allergy not found: Cannot update Allergy.");
        }

        newAllergy.setId(id);
        allergyRepository.save(newAllergy);
    }

    // DELETE

    @Transactional
    public void deleteAllergy(long id) {
        if (!allergyRepository.existsById(id)) {
            throw new FriendNotFoundException("Allergy not found: Cannot delete Allergy.");
        }

        allergyRepository.deleteAllergyById(id);
    }

}
