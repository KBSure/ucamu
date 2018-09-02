package com.project.ucamu.service;

import com.project.ucamu.domain.Comment;
import com.project.ucamu.dto.ContentFormDto;

public interface CommentService {
    boolean addComment(Comment comment, ContentFormDto commentFormDto);
    boolean deleteComment(Long commentId);
}
