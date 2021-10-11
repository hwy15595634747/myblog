package com.hwy.blog.controller;

import com.hwy.blog.service.CommentsService;
import com.hwy.blog.vo.Result;
import com.hwy.blog.vo.params.CommentParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("comments")
public class CommentsController {
    ///comments/article/{id}
    @Autowired
    private CommentsService commentsService;

    @GetMapping("article/{id}")
    public Result comment(@PathVariable("id") Long id){
        return commentsService.commentsByArticleId(id);
    }

    @PostMapping("create/change")
    public Result comment(@RequestBody CommentParam commentParam){
        return commentsService.comment(commentParam);
    }
}
