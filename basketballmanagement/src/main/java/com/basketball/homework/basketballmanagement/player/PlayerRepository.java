package com.basketball.homework.basketballmanagement.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    //SELECT * from Player where name =
    @Query("Select s FROM Player s where s.name = ?1")
    Optional<Player> findPlayerByName(String name);


}
