package com.api.simpleuserscore.service;

import com.api.simpleuserscore.entity.User;
import com.api.simpleuserscore.entity.UserProgress;

public interface UserProgressService {
    void createUserProgress(UserProgress theUserProgress);
    UserProgress findUserProgressById(long theId);
}
