package com.project.ucamu.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "USERS")
@Entity
@Getter @Setter
public class User implements Serializable {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

@Column(name = "id_name")
    String idName;
    String password;
@Column(name = "nick_name")
    String nickName;
    String name;
    String email;
    String phone;
@Column(name = "reg_date")
    LocalDateTime regDate;
@Column(name = "situation_start_date")
    LocalDateTime situationStartDate;
@Column(name = "situation_end_date")
    LocalDateTime situationEndDate;

@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
@JoinColumn(name = "situation_id")
    UserSituation userSituation;

@ManyToMany(cascade = CascadeType.ALL)
@JoinTable(name = "ROLE_USER",
        joinColumns = @JoinColumn(name = "USERS_id"), inverseJoinColumns = @JoinColumn(name = "ROLES_id"))
    List<Role> roleList = new ArrayList<>();
}
