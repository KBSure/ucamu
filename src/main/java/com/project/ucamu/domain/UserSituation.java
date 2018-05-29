package com.project.ucamu.domain;

import com.project.ucamu.domain.enums.SituationState;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "SITUATION")
@Entity
@Getter @Setter
public class UserSituation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
    @Enumerated(value = EnumType.STRING)
        private SituationState state;
}