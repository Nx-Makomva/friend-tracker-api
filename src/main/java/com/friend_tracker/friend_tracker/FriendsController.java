package com.friend_tracker.friend_tracker;

import com.friend_tracker.friend_tracker.Allergy.Allergy;
import com.friend_tracker.friend_tracker.Allergy.AllergyService;
import com.friend_tracker.friend_tracker.Profile.Profile;
import com.friend_tracker.friend_tracker.Profile.ProfileService;
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
    ProfileService profileService;
    @Autowired
    AllergyService allergyService;
//    @Autowired
//    FriendProfileAllergyMapping friendProfileAllergyMapping;

    @ExceptionHandler
    public ResponseEntity<String> handleExceptions(FriendNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
    // CREATE

    // PROFILES

    @PostMapping("/profile")
    public ResponseEntity<Profile> createProfile(@RequestBody Profile profile) {
        profileService.addProfile(profile);

        return ResponseEntity.status(HttpStatus.CREATED).body(profile);
    }

    // ALLERGIES

    @PostMapping("/allergy")
    public ResponseEntity<Allergy> createAllergy(@RequestBody Allergy allergy) {
//        allergyService.addAllergy(allergy);

        return ResponseEntity.status(HttpStatus.CREATED).body(allergy);
    }


    // READ

    // PROFILES
    @GetMapping("/profiles")
    public ResponseEntity<List<Profile>> getProfile(@RequestParam(required = false) String profileName,
                                                    @RequestParam(defaultValue = "15") int limit) {

        if (profileName != null) {
           return ResponseEntity.status(HttpStatus.OK).body(profileService.getByName(profileName));
        }

        return ResponseEntity.status(HttpStatus.OK).body(profileService.getAllProfiles(limit));
    }

    @GetMapping("profiles/birthday")
    public ResponseEntity<List<Profile>> getBirthdaysBetween(@RequestParam(required = false) LocalDate startDate, LocalDate endDate,
                                                             @RequestParam(defaultValue = "15") int limit ) {
        if (startDate != null && endDate != null) {
            return ResponseEntity.status(HttpStatus.OK).body(profileService.getByBirthdayBetween(startDate, endDate));
        }

        return ResponseEntity.status(HttpStatus.OK).body(profileService.getAllBirthday(limit));
    }

    @GetMapping("profiles/occupation")
    public ResponseEntity<List<Profile>> getOccupation(@RequestParam(required = false) String occupation,
                                                       @RequestParam(defaultValue = "25") int limit ) {
        if (occupation != null) {
            return ResponseEntity.status(HttpStatus.OK).body(profileService.getByOccupation(occupation));
        }

        return ResponseEntity.status(HttpStatus.OK).body(profileService.getAllOccupation(limit));
    }


    @GetMapping("profiles/heritage")
    public ResponseEntity<List<Profile>> getHeritage(@RequestParam(required = false) String heritage,
                                                     @RequestParam(defaultValue = "25") int limit ) {
        if (heritage != null) {
            return ResponseEntity.status(HttpStatus.OK).body(profileService.getByHeritage(heritage, limit));
        }

        return ResponseEntity.status(HttpStatus.OK).body(profileService.getAllHeritage(limit));
    }


    @GetMapping("profiles/last-seen")
    public ResponseEntity<List<Profile>> getLastSeen(@RequestParam(required = false) LocalDate startDate, LocalDate endDate,
                                                     @RequestParam(defaultValue = "25") int limit ) {
        if (startDate != null && endDate != null) {
            return ResponseEntity.status(HttpStatus.OK).body(profileService.getByLastSeenBetween(startDate, endDate));
        }

        return ResponseEntity.status(HttpStatus.OK).body(profileService.getAllLastSeen(limit));
    }

    @GetMapping("/profile{id}")
    public ResponseEntity<Profile> getProfileById(@RequestParam long id) {

        return ResponseEntity.status(HttpStatus.OK).body(profileService.getProfileById(id));
    }

    // ALLERGIES

    @GetMapping("/allergies")
    public ResponseEntity<List<Allergy>> getAllergy(@RequestParam(required = false) String allergy,
                                                    @RequestParam(defaultValue = "12") int limit) {

        if (allergy != null) {
            return ResponseEntity.status(HttpStatus.OK).body(allergyService.getByAllergyName(allergy, limit));
        }

        return ResponseEntity.status(HttpStatus.OK).body(allergyService.getAllAllergies(limit)) ;

    }


    // UPDATE

    // PROFILES

    @PutMapping("/profile/{id}")
    @Transactional
    public ResponseEntity<Profile> updateProfile(@RequestBody Profile newProfile,
                                                 @PathVariable long id) {
        newProfile.setId(id);
        profileService.updateProfile(newProfile, id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(newProfile);
    }


    // ALLERGIES


    // DELETE

    // PROFILES

    @DeleteMapping("/profile/{id}")
    @Transactional
    public ResponseEntity<String> deleteProfileById(@PathVariable long id) {
        profileService.deleteProfileById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Profile with id: " + id + " has been deleted");
    }

    // ALLERGIES
}
