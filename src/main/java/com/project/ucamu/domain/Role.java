package com.project.ucamu.domain;

import com.project.ucamu.domain.enums.RoleName;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "ROLE")
@Entity
@Getter @Setter
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "name")
        private RoleName roleName;
}

