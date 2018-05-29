package com.project.ucamu.domain;

import com.project.ucamu.domain.embeddable.Content;
import com.project.ucamu.domain.embeddable.Date;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "BOARDS")
@Entity
@Getter @Setter
public class Board implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String title;
    @Embedded
        private Content content;
    @Embedded
        private Date date;
        private Long view;
        private Integer great;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) //단방향
    @JoinColumn(name = "USERS_id")
        private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) //단방향
    @JoinColumn(name = "CATEGORIES_id")
        private Category category;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL) //단방향
    @JoinColumn(name = "BOARDS_id")
        private List<Comment> commentList;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL) //단방향
    @JoinColumn(name = "BOARDS_id")
        private List<Image> imageList;

    public void addComment(Comment comment){
        this.commentList.add(comment);
    }

    public void addImage(Image image){
        this.imageList.add(image);
    }
}