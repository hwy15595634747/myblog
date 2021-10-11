package com.hwy.blog.service;


import com.hwy.blog.vo.Result;
import com.hwy.blog.vo.params.CommentParam;

public interface CommentsService {
    Result commentsByArticleId(Long id);

    Result comment(CommentParam commentParam);
}
