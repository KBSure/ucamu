package com.project.ucamu.domain;

import com.project.ucamu.domain.embeddable.MiniDate;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "SCRAP")
@Entity
@Getter @Setter
public class Scrap implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

    @Embedded
        private MiniDate date;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) //단방향
    @JoinColumn(name = "USER_id")
        private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) //단방향
    @JoinColumn(name = "BOARD_id")
        private Board board;
}