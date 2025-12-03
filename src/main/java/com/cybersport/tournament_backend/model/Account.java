package com.cybersport.tournament_backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "accounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // связь с AuthAccount (по id)
    @OneToOne
    @JoinColumn(name = "auth_account_id", nullable = false, unique = true)
    private AuthAccount authAccount;
}
