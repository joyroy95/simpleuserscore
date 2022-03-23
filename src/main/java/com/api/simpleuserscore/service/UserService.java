package com.api.simpleuserscore.service;

import com.api.simpleuserscore.entity.User;

public interface UserService {
    void createUser(User user);
    User findByUserId(long theId);
}
