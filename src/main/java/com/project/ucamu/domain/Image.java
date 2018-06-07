package com.project.ucamu.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "IMAGE")
@Entity
@Getter @Setter
public class Image implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String path;

    @Column(name = "mime_type")
        private String mimeType;
        private Integer size;
}
