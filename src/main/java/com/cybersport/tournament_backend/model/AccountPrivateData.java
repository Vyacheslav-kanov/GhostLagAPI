package com.cybersport.tournament_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "account_private_data")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountPrivateData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    @Column(nullable = false)
    private String passwordHash;

    @OneToOne
    @JoinColumn(name = "account_id")
    @JsonIgnore // иначе цикличаня сериализация
    private Account account;
}