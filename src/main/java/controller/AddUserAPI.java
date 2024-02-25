package controller;

import models.User;
import service.UserService;

public class AddUserAPI {

    private final UserService userService;

    public AddUserAPI(UserService userService) {
        this.userService = userService;
    }

    public String addUser(User user){
        return userService.addUser(user);
    }
}
