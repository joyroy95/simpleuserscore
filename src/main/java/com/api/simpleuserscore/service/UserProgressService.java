package com.api.simpleuserscore.service;

import com.api.simpleuserscore.dto.LeaderBoardDto;
import com.api.simpleuserscore.entity.User;
import com.api.simpleuserscore.entity.UserProgress;

import java.util.List;

public interface UserProgressService {
    void createUserProgress(UserProgress theUserProgress);
    UserProgress findUserProgressById(long theId);
    List<LeaderBoardDto> findTopTenScored();
    LeaderBoardDto findUserScoreByUserId(long userId);
}
