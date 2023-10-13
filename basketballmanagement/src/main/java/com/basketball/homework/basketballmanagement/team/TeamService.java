package com.basketball.homework.basketballmanagement.team;

import com.basketball.homework.basketballmanagement.player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getTeams(){
      return teamRepository.findAll();
    }

    public void addNewTeam(Team team) {
        Optional<Team> teamOptional =  teamRepository.findTeamByName(team.getName());
        Optional<Team> tempTeam = teamRepository.findById(team.getId());
        List<Player> player = team.getPlayers();

            if(tempTeam.isPresent()){
                player.get(0).setTeam(tempTeam.get());
                tempTeam.get().setPlayers(player);
            }
            else if (team.getSalaryCap() >  10000){
                throw new IllegalStateException("salary cap cannot exceed 10,0000");
            }





//        if(teamOptional.isPresent()){
//            throw new IllegalStateException("team name is taken!");
//        }
        teamRepository.save(team);


    }

}
