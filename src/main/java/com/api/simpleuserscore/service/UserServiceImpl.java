package com.api.simpleuserscore.service;

import com.api.simpleuserscore.entity.User;
import com.api.simpleuserscore.error.UserNotFoundException;
import com.api.simpleuserscore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Joy Roy
 * @version 1.0
 * @since 3/23/2022
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    /**
     *
     * @param user
     */
    @Override
    public void createUser(User user)
    {
        userRepository.save(user);
    }

    /**
     *
     * @param theId
     * @return
     */
    @Override
    public User findByUserId(long theId) {
        Optional<User> theOptional = userRepository.findById(theId);
        User user = null;
        if(theOptional.isPresent())
        {
            user = theOptional.get();
        }
        else
        {
            throw new UserNotFoundException("User id did not found - " + theId);
        }
        return user;
    }
}
