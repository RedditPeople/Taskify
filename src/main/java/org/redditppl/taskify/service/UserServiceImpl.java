package org.redditppl.taskify.service;

import lombok.RequiredArgsConstructor;
import org.redditppl.taskify.exceptions.UserNotFoundException;
import org.redditppl.taskify.model.User;
import org.redditppl.taskify.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        return userRepository.getById(id);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserByUsername(String username) throws UserNotFoundException {
        Optional<User> matchingObject = userRepository.findAll().stream()
                .filter( u -> u.getUsername().equals(username)).findFirst();
        if(matchingObject.isPresent()){
            return matchingObject.get();
        }else{
            throw new UserNotFoundException("User not found by this username: " + username);
        }
    }
}
