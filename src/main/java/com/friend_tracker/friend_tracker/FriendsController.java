package com.friend_tracker.friend_tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
public class FriendsController {

    @Autowired
    FriendProfileService friendProfileService;
    @Autowired
    FriendAllergyService friendAllergyService;
    @Autowired
    FriendProfileAllergyMapping friendProfileAllergyMapping;

    @GetMapping("/profiles")
    public ResponseEntity<List<FriendProfile>> getProfiles(@RequestParam(required = false) String profileName, @RequestParam(defaultValue = "10") int limit) {

        if (profileName != null) {
           return ResponseEntity.status(HttpStatus.OK).body(friendProfileService.getByName(profileName));
        }

        return ResponseEntity.status(HttpStatus.OK).body(friendProfileService.getAllProfiles(limit));
    }

    @GetMapping("/allergies")
    public ResponseEntity<List<FriendAllergy>> getAllergies(@RequestParam(required = false) String allergy, @RequestParam(defaultValue = "12") int limit) {

        if (allergy != null) {
            return ResponseEntity.status(HttpStatus.OK).body(friendAllergyService.getAllByAllergyName(allergy, limit));
        }

        return ResponseEntity.status(HttpStatus.OK).body(friendAllergyService.getAllAllergies(limit)) ;

    }
}
