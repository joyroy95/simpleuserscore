package com.api.simpleuserscore.entity;

import com.api.simpleuserscore.dto.LeaderBoardDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Joy Roy
 * @version 1.0
 * @since 3/23/2022
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SqlResultSetMapping(name = "findAllLeaderBoardMapping",
        classes = @ConstructorResult(
                targetClass = LeaderBoardDto.class,
                columns = {
                        @ColumnResult(name = "rank", type = int.class),
                        @ColumnResult(name = "level", type = int.class),
                        @ColumnResult(name = "name", type = String.class),
                        @ColumnResult(name = "score", type = Float.class)
                }
        )
)
@NamedNativeQuery(name = "findTop10ScoreNamedQuery",
        resultClass = LeaderBoardDto.class, resultSetMapping = "findAllLeaderBoardMapping",
        query = "SELECT ROW_NUMBER() over () as 'rank', up.level, u.name, up.score " +
                "FROM user_progress up INNER JOIN user u where u.id = up.user_id ORDER BY up.score desc")

@NamedNativeQuery(name = "findUserScoreByUserIdNamedQuery",
        resultClass = LeaderBoardDto.class, resultSetMapping = "findAllLeaderBoardMapping",
        query = "SELECT inn.`rank`, inn.level, inn.name, inn.score " +
                "From (SELECT ROW_NUMBER() over () as 'rank', up.level, u.name, up.score, up.user_id " +
                "FROM user_progress up INNER JOIN user u where u.id = up.user_id order by up.score desc) inn where inn.user_id = :user_id")

public class UserProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private int level;
    private float score;
    @OneToOne(cascade = CascadeType.DETACH, optional = false)
    private User user;
}
