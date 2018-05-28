package com.project.ucamu.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Table(name = "SITUATION")
@Entity
@Getter @Setter
public class UserSituation implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
@Enumerated(value = EnumType.STRING)
    SituationState state;
@OneToMany(cascade = CascadeType.ALL, mappedBy = "userSituation")
    List<User> userList = new ArrayList<>();
}
