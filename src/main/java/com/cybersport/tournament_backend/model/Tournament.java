package com.cybersport.tournament_backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String thumb; //img

    @NotBlank(message = "Название турнира обязательно")
    private String title; //name

    private String formatTournament; //5x5

    private String prize; // P

    @NotNull(message = "Дата турнира обязательна")
    private LocalDate data;

    @NotNull(message = "Статус обязателен")
    private TournamentStatus status;

    private String slots; // 2 / 32

    private TournamentType type; //Онлайн

    private boolean mix;

//    @NotBlank(message = "Город обязательный")
//    private String city;

//    private String club;

//    @NotNull(message = "Пул карт обязателен")
//    private MapText cardText;

}
