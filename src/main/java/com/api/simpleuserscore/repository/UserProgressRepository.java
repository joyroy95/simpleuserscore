package com.api.simpleuserscore.repository;

import com.api.simpleuserscore.dto.LeaderBoardDto;
import com.api.simpleuserscore.entity.UserProgress;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserProgressRepository extends JpaRepository<UserProgress, Long> {
    @Query(nativeQuery = true, name = "findTop10ScoreNamedQuery")
    List<LeaderBoardDto> findTop10ByOrderByScoreDesc(Pageable pageable);

    @Query(nativeQuery = true, name = "findUserScoreByUserIdNamedQuery")
    Optional<LeaderBoardDto> findUserScoreByUserId(@Param("user_id") long userId);


}
