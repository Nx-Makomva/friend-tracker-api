package com.friend_tracker.friend_tracker;

public class FriendNotFoundException extends RuntimeException {
    public FriendNotFoundException(String message) {
        super(message);
    }
}
