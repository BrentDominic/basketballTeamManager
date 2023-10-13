package com.basketball.homework.basketballmanagement.team;

import com.basketball.homework.basketballmanagement.player.Player;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private double salaryCap;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="team_id")
    private List<Player> players;

    private LocalDate dateCreated;

    public Team() {
    }

    public Team(Long id, String name, double salaryCap, List<Player> players, LocalDate dateCreated) {
        this.id = id;
        this.name = name;
        this.salaryCap = salaryCap;
        this.players = players;
        this.dateCreated = dateCreated;
    }

    public Team(String name, double salaryCap, List<Player> players, LocalDate dateCreated) {
        this.name = name;
        this.salaryCap = salaryCap;
        this.players = players;
        this.dateCreated = dateCreated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalaryCap() {
        return salaryCap;
    }

    public void setSalaryCap(double salaryCap) {
        this.salaryCap = salaryCap;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salaryCap=" + salaryCap +
                ", players=" + players +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
