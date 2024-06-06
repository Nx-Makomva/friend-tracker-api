package com.friend_tracker.friend_tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FriendAllergyService {

    @Autowired
    FriendAllergyRepository friendAllergyRepository;

    // CREATE


    // READ
    public List<FriendAllergy> getAllByAllergyName(String allergy, int limit) {
        List<FriendAllergy> allergies = friendAllergyRepository.getAllByAllergyName(allergy);

        return allergies
                .stream()
                .limit(limit)
                .collect(Collectors.toList());

    }

    public List<FriendAllergy> getAllAllergies(int limit) {
        return friendAllergyRepository
                .findAll()
                .stream()
                .limit(limit)
                .collect(Collectors.toList());
    }


    // UPDATE


    // DELETE
}
