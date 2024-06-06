package com.friend_tracker.friend_tracker.Profile;

import com.friend_tracker.friend_tracker.FriendNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfileService {

    @Autowired
    ProfileRepository profileRepository;

    // CREATE

    public void addProfile(Profile profile) {
        profileRepository.save(profile);
    }

    // READ

    public List<Profile> getAllProfiles(int limit) {
        return profileRepository
                .findAll()
                .stream()
                .limit(limit)
                .collect(Collectors.toList());
    }

    public Profile getProfileById(long id) {
       Optional<Profile> profile = profileRepository.findById(id);

       if (profile.isEmpty()) {
          throw new FriendNotFoundException("Profile not found");
       }

        return profile.get();
    }

    public List<Profile> getByName(String profileName) {

        return profileRepository.getAllByName(profileName);
    }

    public List<Profile> getAllBirthday(int limit) {
        return profileRepository
                .findAll()
                .stream()
                .limit(limit)
                .sorted(Comparator.comparing((Profile profile) -> profile.getBirthday().getMonth())
                        .thenComparing(Profile::getBirthday))
                .collect(Collectors.toList());
    }

    public List<Profile> getByBirthdayBetween(LocalDate startDate, LocalDate endDate) {
        return profileRepository.getAllByBirthdayBetween(startDate, endDate);
    }


    public List<Profile> getAllOccupation(int limit) {
        return profileRepository
                .findAll()
                .stream()
                .limit(limit)
                .sorted(Comparator.comparing(Profile::getOccupation))
                .collect(Collectors.toList());
    }

    public List<Profile> getByOccupation(String occupation) {
        return profileRepository.getAllByOccupation(occupation);
    }

    public List<Profile> getAllHeritage(int limit) {
        return profileRepository
                .findAll()
                .stream()
                .limit(limit)
                .sorted(Comparator.comparing(Profile::getHeritage))
                .collect(Collectors.toList());
    }

    public List<Profile> getByHeritage(String heritage, int limit) {
        List<Profile> profiles = profileRepository.getAllByHeritage(heritage);

        return profiles
                .stream()
                .limit(limit)
                .collect(Collectors.toList());
    }

    public List<Profile> getAllLastSeen(int limit) {
        return profileRepository
                .findAll()
                .stream()
                .limit(limit)
                .sorted(Comparator.comparing(Profile::getLastSeen))
                .collect(Collectors.toList());
    }

    public List<Profile> getByLastSeenBetween(LocalDate startDate, LocalDate endDate) {
        return profileRepository.getAllByLastSeenBetween(startDate, endDate);
    }

    // UPDATE

    @Transactional
    public void updateProfile(Profile newProfile, long id) {
        if (!profileRepository.existsById(id)) {
            throw new FriendNotFoundException("Profile not Found: Cannot update Profile.");
        }

        newProfile.setId(id);

        profileRepository.save(newProfile);
    }

    // DELETE

    @Transactional
    public void deleteProfileById(long id) {
        if (!profileRepository.existsById(id)) {
            throw new FriendNotFoundException("Profile not Found: Cannot delete Profile.");
        }

         profileRepository.deleteProfileById(id);
    }

}
