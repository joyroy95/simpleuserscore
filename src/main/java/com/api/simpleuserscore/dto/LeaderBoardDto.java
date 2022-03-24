package com.api.simpleuserscore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Joy Roy
 * @version 1.0
 * @since 3/24/2022
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeaderBoardDto {
    private int rank;
    private int level;
    private String name;
    private float score;
}
