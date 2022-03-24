package com.api.simpleuserscore.controller;

import com.api.simpleuserscore.entity.User;
import com.api.simpleuserscore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author Joy Roy
 * @version 1.0
 * @since 3/23/2022
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    // add mapping for GET single user
    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable long userId)
    {
        return userService.findByUserId(userId);
    }

    // add mapping for POST /users -- add new user
    @PostMapping("/users")
    public User createUser(@RequestBody User theUser)
    {
        // also in case the pass an id in json.....set id to 0
        // this is force of save a new item.... instead of update
        theUser.setId(0);
        userService.createUser(theUser);
        return theUser;
    }

    // add mapping for PUT /users -- update existing user
    @PutMapping("/users")
    public User updateUser(@RequestBody User theUser)
    {
        userService.createUser(theUser);
        return theUser;
    }

}
