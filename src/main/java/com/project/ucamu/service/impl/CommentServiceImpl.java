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
}
