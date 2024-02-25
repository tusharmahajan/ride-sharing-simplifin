package service;

import models.User;
import repository.UserRepository;

public class UserService {

    public String addUser(User user) {
        if(user == null){
            return "User details are empty";
        }
        if(user.getName().equals("") || user.getAge() < 0){
            return "Invalid user details entered";
        }
        return UserRepository.storeUser(user);
    }
}
