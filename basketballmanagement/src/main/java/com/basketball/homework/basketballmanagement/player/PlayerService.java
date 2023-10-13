package com.basketball.homework.basketballmanagement.player;

import com.basketball.homework.basketballmanagement.team.Team;
import com.basketball.homework.basketballmanagement.team.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService{
    @Autowired
    private  PlayerRepository playerRepository;
    @Autowired
    private TeamRepository teamRepository;



    public List<Player> getPlayers(){
        return playerRepository.findAll();
    }


    public void addNewPlayer(Player player) {
        Optional<Player> playerOptional = playerRepository.findPlayerByName(player.getName());
        Team team = player.getTeam();
       Optional<Team> teamName = teamRepository.findTeamByName(team.getName());
        if(playerOptional.isPresent()){
            System.out.println("number of players are: " + getPlayers().size());
            throw new IllegalStateException("name is taken");

        }else if(getPlayers().size() > 12){
            throw new IllegalStateException("too many players");
        }else if(!player.getName().matches("[A-Za-z]+")){
            throw new IllegalStateException("name cannot contain digits");
        }
       else if(teamName.isPresent()){
            System.out.println("team name present warning" );
           playerRepository.save(player);
       }
        player.setTeam(team);
        playerRepository.save(player);

    }

    public void deletePlayer(Long playerId) {
        boolean exists = playerRepository.existsById(playerId);
        if (!exists){
            throw new IllegalStateException("player id " + playerId + " does not exist" );
        }
        playerRepository.deleteById(playerId);
    }
}
