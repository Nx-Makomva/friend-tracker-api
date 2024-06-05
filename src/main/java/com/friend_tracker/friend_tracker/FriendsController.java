package com.friend_tracker.friend_tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
public class FriendsController {

    @Autowired
    FriendProfileService friendProfileService;

    @GetMapping("/allergies")
    public ResponseEntity<List<FriendProfile>> getAllergies(@RequestParam(required = false) String allergies, @RequestParam(defaultValue = "10") int limit) {

        if (allergies != null) {
            return ResponseEntity.status(HttpStatus.OK).body(friendProfileService.getAllByHeritage(allergies, limit));
        }

        return ResponseEntity.status(HttpStatus.OK).body(friendProfileService.getAllAllergies(limit)) ;

    }
}
