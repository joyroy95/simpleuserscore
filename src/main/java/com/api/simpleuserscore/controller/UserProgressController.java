package com.api.simpleuserscore.controller;

import com.api.simpleuserscore.entity.User;
import com.api.simpleuserscore.entity.UserProgress;
import com.api.simpleuserscore.service.UserProgressService;
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
public class UserProgressController {
    private final UserProgressService userProgressService;
    // add mapping for GET single user progress
    @GetMapping("/userProgress/{userProgressId}")
    public UserProgress getUserProgressById(@PathVariable long userProgressId)
    {
        return userProgressService.findUserProgressById(userProgressId);
    }

    // add mapping for POST /userProgress -- add new user progress
    @PostMapping("/userProgress")
    public UserProgress createUserProgress(@RequestBody UserProgress theUserProgress)
    {
        // also in case the pass an id in json.....set id to 0
        // this is force of save a new item.... instead of update
        theUserProgress.setId(0);
        userProgressService.createUserProgress(theUserProgress);
        return theUserProgress;
    }

    // add mapping for PUT /userProgress -- update existing user progress
    @PutMapping("/userProgress")
    public UserProgress updateUserProgress(@RequestBody UserProgress theUserProgress)
    {
        userProgressService.createUserProgress(theUserProgress);
        return theUserProgress;
    }
}
