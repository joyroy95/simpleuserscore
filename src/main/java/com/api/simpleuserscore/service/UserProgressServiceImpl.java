package com.api.simpleuserscore.service;

import com.api.simpleuserscore.entity.User;
import com.api.simpleuserscore.entity.UserProgress;
import com.api.simpleuserscore.repository.UserProgressRepository;
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
public class UserProgressServiceImpl implements UserProgressService{
    private final UserProgressRepository userProgressRepository;

    /**
     *
     * @param theUserProgress
     */
    @Override
    public void createUserProgress(UserProgress theUserProgress) {
        userProgressRepository.save(theUserProgress);
    }

    /**
     *
     * @param theId
     * @return
     */
    @Override
    public UserProgress findUserProgressById(long theId) {
        Optional<UserProgress> theOptional = userProgressRepository.findById(theId);
        UserProgress userProgress = null;
        if(theOptional.isPresent())
        {
            userProgress = theOptional.get();
        }
        else
        {
            throw new RuntimeException("User progress id did not found - " + theId);
        }
        return userProgress;

    }
}
