package com.basketball.homework.basketballmanagement.team;

import com.basketball.homework.basketballmanagement.player.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    @Query("SELECT s FROM Team s WHERE s.name = ?1")
    Optional<Team> findTeamByName(String name);



}
