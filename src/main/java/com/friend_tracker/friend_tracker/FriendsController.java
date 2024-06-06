package com.friend_tracker.friend_tracker;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
public class FriendsController {

    @Autowired
    FriendProfileService friendProfileService;
    @Autowired
    FriendAllergyService friendAllergyService;
//    @Autowired
//    FriendProfileAllergyMapping friendProfileAllergyMapping;

    @ExceptionHandler
    public ResponseEntity<String> handleExceptions(FriendNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
    // CREATE

    // PROFILES

    @PostMapping("/profile")
    public ResponseEntity<FriendProfile> createProfile(@RequestBody FriendProfile profile) {
        friendProfileService.addProfile(profile);

        return ResponseEntity.status(HttpStatus.CREATED).body(profile);
    }

    // ALLERGIES

    @PostMapping("/allergy")
    public ResponseEntity<FriendAllergy> createAllergy(@RequestBody FriendAllergy allergy) {
//        friendAllergyService.addAllergy(allergy);

        return ResponseEntity.status(HttpStatus.CREATED).body(allergy);
    }


    // READ

    // PROFILES
    @GetMapping("/profiles")
    public ResponseEntity<List<FriendProfile>> getProfile(@RequestParam(required = false) String profileName,
                                                           @RequestParam(defaultValue = "15") int limit) {

        if (profileName != null) {
           return ResponseEntity.status(HttpStatus.OK).body(friendProfileService.getByName(profileName));
        }

        return ResponseEntity.status(HttpStatus.OK).body(friendProfileService.getAllProfiles(limit));
    }

    @GetMapping("profiles/birthday")
    public ResponseEntity<List<FriendProfile>> getBirthdaysBetween(@RequestParam(required = false) LocalDate startDate, LocalDate endDate,
                                                             @RequestParam(defaultValue = "15") int limit ) {
        if (startDate != null && endDate != null) {
            return ResponseEntity.status(HttpStatus.OK).body(friendProfileService.getByBirthdayBetween(startDate, endDate));
        }

        return ResponseEntity.status(HttpStatus.OK).body(friendProfileService.getAllBirthday(limit));
    }

    @GetMapping("profiles/occupation")
    public ResponseEntity<List<FriendProfile>> getOccupation(@RequestParam(required = false) String occupation,
                                                                   @RequestParam(defaultValue = "25") int limit ) {
        if (occupation != null) {
            return ResponseEntity.status(HttpStatus.OK).body(friendProfileService.getByOccupation(occupation));
        }

        return ResponseEntity.status(HttpStatus.OK).body(friendProfileService.getAllOccupation(limit));
    }


    @GetMapping("profiles/heritage")
    public ResponseEntity<List<FriendProfile>> getHeritage(@RequestParam(required = false) String heritage,
                                                             @RequestParam(defaultValue = "25") int limit ) {
        if (heritage != null) {
            return ResponseEntity.status(HttpStatus.OK).body(friendProfileService.getByHeritage(heritage, limit));
        }

        return ResponseEntity.status(HttpStatus.OK).body(friendProfileService.getAllHeritage(limit));
    }


    @GetMapping("profiles/last-seen")
    public ResponseEntity<List<FriendProfile>> getLastSeen(@RequestParam(required = false) LocalDate startDate, LocalDate endDate,
                                                                   @RequestParam(defaultValue = "25") int limit ) {
        if (startDate != null && endDate != null) {
            return ResponseEntity.status(HttpStatus.OK).body(friendProfileService.getByLastSeenBetween(startDate, endDate));
        }

        return ResponseEntity.status(HttpStatus.OK).body(friendProfileService.getAllLastSeen(limit));
    }

    @GetMapping("/profile{id}")
    public ResponseEntity<FriendProfile> getProfileById(@RequestParam long id) {

        return ResponseEntity.status(HttpStatus.OK).body(friendProfileService.getProfileById(id));
    }

    // ALLERGIES

    @GetMapping("/allergies")
    public ResponseEntity<List<FriendAllergy>> getAllergy(@RequestParam(required = false) String allergy,
                                                            @RequestParam(defaultValue = "12") int limit) {

        if (allergy != null) {
            return ResponseEntity.status(HttpStatus.OK).body(friendAllergyService.getByAllergyName(allergy, limit));
        }

        return ResponseEntity.status(HttpStatus.OK).body(friendAllergyService.getAllAllergies(limit)) ;

    }


    // UPDATE

    // PROFILES

    @PutMapping("/profile/{id}")
    @Transactional
    public ResponseEntity<FriendProfile> updateProfile(@RequestBody FriendProfile newProfile,
                                                       @PathVariable long id) {
        newProfile.setId(id);
        friendProfileService.updateProfile(newProfile, id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(newProfile);
    }


    // ALLERGIES


    // DELETE

    // PROFILES

    @DeleteMapping("/profile/{id}")
    @Transactional
    public ResponseEntity<String> deleteProfileById(@PathVariable long id) {
        friendProfileService.deleteProfileById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Profile with id: " + id + " has been deleted");
    }

    // ALLERGIES
}
