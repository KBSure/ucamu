package com.project.ucamu.domain;

import com.project.ucamu.domain.embeddable.Content;
import com.project.ucamu.domain.embeddable.NormalDate;
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
        private NormalDate date; //서버 날짜로 저장
        private Long view; //0
        private Integer great; //0

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST}) //단방향
    @JoinColumn(name = "USER_id")
        private User user; //session 정보

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST}) //단방향
    @JoinColumn(name = "CATEGORY_id")
        private Category category; //path 내의 카테고리 : board/free

    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY, cascade = CascadeType.ALL) //양방향
        private List<Comment> commentList; // 비워두기

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL) //단방향
    @JoinColumn(name = "BOARD_id")
        private List<Image> imageList; // 있으면 넣고, 없으면 비워두기

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "USER_id")
        private List<User> greatUserList;


    public void setUpView(){
        this.view++;
    }

    public void addComment(Comment comment){
        this.commentList.add(comment);
    }

    public void addImage(Image image){
        this.imageList.add(image);
    }

    public void addGreatUser(User user) {
        this.greatUserList.add(user);
    }
}