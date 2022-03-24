package com.api.simpleuserscore.controller;

import com.api.simpleuserscore.dto.LeaderBoardDto;
import com.api.simpleuserscore.entity.UserProgress;
import com.api.simpleuserscore.service.UserProgressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Joy Roy
 * @version 1.0
 * @since 3/23/2022
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LeaderBoardController {
    private final UserProgressService userProgressService;

    @GetMapping("/leaderboard")
    public List<LeaderBoardDto> getTopScoredValue()
    {
        return userProgressService.findTopTenScored();
    }

    @GetMapping("/leaderboard/{userId}")
    public LeaderBoardDto getUserProgressById(@PathVariable long userId)
    {
        return userProgressService.findUserScoreByUserId(userId);
    }
}
