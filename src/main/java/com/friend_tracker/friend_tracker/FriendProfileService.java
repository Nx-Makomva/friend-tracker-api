package com.friend_tracker.friend_tracker;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FriendProfileService {

    @Autowired
    FriendProfileRepository friendProfileRepository;

    // CREATE

    public void addProfile(FriendProfile profile) {
        friendProfileRepository.save(profile);
    }

    // READ

    public List<FriendProfile> getAllProfiles(int limit) {
        return friendProfileRepository
                .findAll()
                .stream()
                .limit(limit)
                .collect(Collectors.toList());
    }

    public FriendProfile getById(long id) {
       Optional<FriendProfile> profile = friendProfileRepository.findById(id);

       if (profile.isEmpty()) {
          throw new FriendNotFoundException("Profile not found");
       }

        return profile.get();
    }

    public List<FriendProfile> getByName(String profileName) {

        return friendProfileRepository.getAllByName(profileName);
    }

    public List<FriendProfile> getByBirthdayBetween(LocalDate startDate, LocalDate endDate) {
        return friendProfileRepository.getAllByBirthdayBetween(startDate, endDate);
    }

    public List<FriendProfile> getByOccupation(String occupation) {
        return friendProfileRepository.getAllByOccupation(occupation);
    }


    public List<FriendProfile> getAllByHeritage(String heritage, int limit) {
        List<FriendProfile> profiles = friendProfileRepository.getAllByHeritage(heritage);

        return profiles
                .stream()
                .limit(limit)
                .collect(Collectors.toList());
    }

    public List<FriendProfile> getByLastSeenBetween(LocalDate startDate, LocalDate endDate) {
        return friendProfileRepository.getAllByLastSeenBetween(startDate, endDate);
    }

    // UPDATE

    @Transactional
    public void updateProfile(FriendProfile newProfile, long id) {
        if (!friendProfileRepository.existsById(id)) {
            throw new FriendNotFoundException("Profile not Found: Cannot update Profile.");
        }

        newProfile.setId(id);

        friendProfileRepository.save(newProfile);
    }

    // DELETE

    @Transactional
    public void deleteProfileById(long id) {
        if (!friendProfileRepository.existsById(id)) {
            throw new FriendNotFoundException("Profile not Found: Cannot delete Profile.");
        }

         friendProfileRepository.deleteProfileById(id);
    }

}
