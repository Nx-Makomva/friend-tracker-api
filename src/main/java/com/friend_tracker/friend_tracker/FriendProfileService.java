package com.friend_tracker.friend_tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FriendProfileService {

    @Autowired
    FriendProfileRepository friendProfileRepository;

    public List<FriendProfile> getAllAllergies(int limit) {
        return friendProfileRepository
                .findAll()
                .stream()
                .limit(limit)
                .collect(Collectors.toList());

    }

    public List<FriendProfile> getAllByHeritage(String heritage, int limit) {
        List<FriendProfile> profiles = friendProfileRepository.getAllByHeritage(heritage);

        return profiles
                .stream()
                .limit(limit)
                .collect(Collectors.toList());
    }
}
