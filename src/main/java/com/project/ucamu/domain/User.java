package com.project.ucamu.domain;

import com.project.ucamu.domain.embeddable.UserDate;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Table(name = "USER")
@Entity
@Getter @Setter
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

    @Column(name = "id_name")
        private String idName;
        private String password;

    @Column(name = "nickname")
        private String nickname;
        private String name;
        private String email;
        private String phone;

    @Embedded
        private UserDate userdate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) //단방향
    @JoinColumn(name = "situation_id")
        private UserSituation userSituation;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL) //단방향
    @JoinTable(name = "ROLE_USER", joinColumns = @JoinColumn(name = "USERS_id"),
            inverseJoinColumns = @JoinColumn(name = "ROLES_id"))
        private List<Role> roleList = new ArrayList<>();

    public void addRole(Role role){
        if(!roleList.contains(role)){
            roleList.add(role);
        }
    }
}
