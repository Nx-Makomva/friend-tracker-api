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

    @GetMapping("/profiles")
    public ResponseEntity<List<FriendProfile>> getProfiles(@RequestParam(required = false) String profileName, @RequestParam(defaultValue = "10") int limit) {

        if (profileName != null) {
           return ResponseEntity.status(HttpStatus.OK).body(friendProfileService.getByName(profileName));
        }

        return ResponseEntity.status(HttpStatus.OK).body(friendProfileService.getAllProfiles(limit));
    }

    @GetMapping("/allergies")
    public ResponseEntity<List<FriendProfile>> getAllergies(@RequestParam(required = false) String allergies, @RequestParam(defaultValue = "10") int limit) {

        if (allergies != null) {
            return ResponseEntity.status(HttpStatus.OK).body(friendProfileService.getAllByHeritage(allergies, limit));
        }

        return ResponseEntity.status(HttpStatus.OK).body(friendProfileService.getAllAllergies(limit)) ;

    }
}
