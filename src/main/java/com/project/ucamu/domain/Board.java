package com.project.ucamu.domain;

import com.project.ucamu.domain.embeddable.Content;
import com.project.ucamu.domain.embeddable.Date;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "BOARD")
@Entity
@Getter @Setter
public class Board implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String title; //form 에서부터 20글자에 가장 가까운 항목으로
    @Embedded
        private Content content; //form에서 가져오기
    @Embedded
        private Date date; //서버 날짜로 저장
        private Long view; //0
        private Integer great; //0

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) //단방향
    @JoinColumn(name = "USERS_id")
        private User user; //session 정보

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) //단방향
    @JoinColumn(name = "CATEGORIES_id")
        private Category category; //path 내의 카테고리 : board/free

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL) //단방향
    @JoinColumn(name = "BOARDS_id")
        private List<Comment> commentList; // 비워두기

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL) //단방향
    @JoinColumn(name = "BOARDS_id")
        private List<Image> imageList; // 있으면 넣고, 없으면 비워두기

    public void addComment(Comment comment){
        this.commentList.add(comment);
    }

    public void addImage(Image image){
        this.imageList.add(image);
    }
}