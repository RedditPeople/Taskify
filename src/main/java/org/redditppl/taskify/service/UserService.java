package org.redditppl.taskify.service;

import org.redditppl.taskify.exceptions.UserNotFoundException;
import org.redditppl.taskify.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(long id);
    User saveUser(User user);
    User getUserByUsername(String username) throws UserNotFoundException;
}
