package com.project.ucamu.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Table(name = "ROLES")
@Entity
@Getter @Setter
public class Role implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
@Enumerated(value = EnumType.STRING)
@Column(name = "name")
    RoleName roleName;
@ManyToMany(mappedBy = "roleList", cascade = CascadeType.ALL)
    List<User> userList = new ArrayList<>();
}

