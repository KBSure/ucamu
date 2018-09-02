package com.project.ucamu.service.impl;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.project.ucamu.domain.Comment;
import com.project.ucamu.domain.embeddable.Content;
import com.project.ucamu.domain.embeddable.NormalDate;
import com.project.ucamu.dto.ContentFormDto;
import com.project.ucamu.repository.CommentRepository;
import com.project.ucamu.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public boolean addComment(Comment comment, ContentFormDto commentFormDto) {
        comment.setContent(new Content());
        BeanUtils.copyProperties(commentFormDto, comment.getContent());
        comment.setDate(new NormalDate(LocalDateTime.now(), LocalDateTime.now()));
        comment.setGreat(0);
        commentRepository.save(comment);
        return true;
    }

    @Override
    public boolean deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).get();
        comment.getDate().setRegDate(LocalDateTime.now());
        Content content = new Content();
        content.setWho(comment.getUser().getNickname() + "님이");
        content.setWhen(comment.getDate().getRegDate().format(DateTimeFormatter.ofPattern("MM월 dd일 경,"))); //점검 필수
        content.setWhere("'" + comment.getBoard().getTitle() + "' 게시글에서");
        content.setWhat("본인의 댓글을");
        content.setHow("삭제하셨습니다");
        content.setWhy("^^");
        comment.setContent(content);
        commentRepository.save(comment);
        return true;
    }
}
