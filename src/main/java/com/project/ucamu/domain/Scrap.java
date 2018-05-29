package com.project.ucamu.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "SCRAPS")
@Entity
@Getter @Setter
public class Scrap implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) //단방향
    @JoinColumn(name = "USERS_id")
        private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) //단방향
    @JoinColumn(name = "BOARDS_id")
        private Board board;
}