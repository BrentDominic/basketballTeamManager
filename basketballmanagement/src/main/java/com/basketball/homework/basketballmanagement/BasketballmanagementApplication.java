package com.basketball.homework.basketballmanagement;

import com.basketball.homework.basketballmanagement.player.Player;
import com.basketball.homework.basketballmanagement.player.PlayerController;
import com.basketball.homework.basketballmanagement.player.PlayerRepository;
import com.basketball.homework.basketballmanagement.player.PlayerService;
import com.basketball.homework.basketballmanagement.team.Team;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@RestController
public class BasketballmanagementApplication {

	public static void main(String[] args) {

		SpringApplication.run(BasketballmanagementApplication.class, args);
	}


}
