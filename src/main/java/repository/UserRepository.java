package repository;

import models.User;

import java.util.HashMap;

public class UserRepository {
//  key is username. Unique identifier
    private static final HashMap<String, User> userStore = new HashMap<>();

    private UserRepository(){}

    public static String storeUser(User user) {
        userStore.put(user.getName(), user);
        RideRepository.initializeRideStatsForUser(user.getName());
        return "Successfully stored user: " + user.getName();
    }

    public static User getUserDetails(String userName){
        return userStore.get(userName);
    }
}
