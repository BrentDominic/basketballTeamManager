package com.basketball.homework.basketballmanagement.player;

import com.basketball.homework.basketballmanagement.team.Team;
import jakarta.persistence.*;

import java.util.Optional;

enum Positions{
    PG, SG, SF, PF, C
}
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO
    )
    private Long id;
    private String name;

    private double height;
    private String position;
    private double salary;
    private Integer age;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Team team;

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Player() {

    }

    public Player(Long id, String name, double height, String position, double salary, Integer age) {
        this.id = id;
        this.name = name;
        this.height = height;
        switch(position) {
            case "PG":
                this.position = Positions.PG.toString();
                break;
            case "SG":
                this.position = Positions.SG.toString();
                break;
            case "SF":
                this.position = Positions.SF.toString();
                break;
            case "PF":
                this.position = Positions.PF.toString();
                break;
            case "C":
                this.position = Positions.C.toString();
                break;
        }
        this.salary = salary;
        this.age = age;
    }

    public Player(String name, double height, String position, double salary, Integer age) {
        this.name = name;

        this.height = height;
        switch(position) {
            case "PG":
                this.position = Positions.PG.toString();
                break;
            case "SG":
                this.position = Positions.SG.toString();
                break;
            case "SF":
                this.position = Positions.SF.toString();
                break;
            case "PF":
                this.position = Positions.PF.toString();
                break;
            case "C":
                this.position = Positions.C.toString();
                break;
        }
            // this.position = position;
        this.salary = salary;
        this.age = age;
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


    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", height=" + height +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}
