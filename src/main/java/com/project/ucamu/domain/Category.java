package com.project.ucamu.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "CATEGORY")
@Entity
@Getter @Setter
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private String name;
    @Column(name = "name_kr")
        private String nameKr;
}
