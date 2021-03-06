package com.project.ucamu.domain;

import com.project.ucamu.domain.embeddable.Content;
import com.project.ucamu.domain.embeddable.NormalDate;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "COMMENT")
@Entity
@Getter @Setter
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
    @Embedded
        private Content content;
    @Embedded
        private NormalDate date;
        private Integer great;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) //단방향
    @JoinColumn(name = "USER_id")
        private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST}) //양방향
    @JoinColumn(name = "BOARD_id")
        private Board board;

}
