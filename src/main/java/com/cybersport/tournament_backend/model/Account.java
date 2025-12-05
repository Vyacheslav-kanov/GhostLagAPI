package com.cybersport.tournament_backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "accounts")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // связь с AuthAccount (по id)
    @OneToOne
    @JoinColumn(name = "account_private_id", nullable = false, unique = true)
    private AccountPrivateData accountPrivateData;

    @OneToOne
    @JoinColumn(name = "account_public_id", nullable = false, unique = true)
    private AccountPublicData accountPublicData;

    private boolean isDeleted;
}
