package com.api.simpleuserscore.service;

import com.api.simpleuserscore.dto.LeaderBoardDto;
import com.api.simpleuserscore.entity.UserProgress;
import com.api.simpleuserscore.error.UserNotFoundException;
import com.api.simpleuserscore.repository.UserProgressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
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
            throw new UserNotFoundException("User progress id did not found - " + theId);
        }
        return userProgress;
    }

    @Override
    public List<LeaderBoardDto> findTopTenScored() {
            return userProgressRepository.findTop10ByOrderByScoreDesc(PageRequest.of(0,10));
    }

    @Override
    public LeaderBoardDto findUserScoreByUserId(long userId) {
        Optional<LeaderBoardDto> leaderBoardDtoOptional= userProgressRepository.findUserScoreByUserId(userId);

        LeaderBoardDto leaderBoardDto = null;
        if(leaderBoardDtoOptional.isPresent())
        {
            leaderBoardDto = leaderBoardDtoOptional.get();
        }
        else
        {
            throw new UserNotFoundException("User id did not found - " + userId);
        }
        return leaderBoardDto;
    }


}
