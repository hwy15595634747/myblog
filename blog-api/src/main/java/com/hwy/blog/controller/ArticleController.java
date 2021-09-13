package com.hwy.blog.controller;


import com.hwy.blog.service.ArticleService;
import com.hwy.blog.vo.Result;
import com.hwy.blog.vo.params.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//返回json数据
@RestController
@RequestMapping("articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    /**
     * 首页文章列表
     * @param pageParams
     * @return
     */
    @PostMapping
    public Result listArticle(@RequestBody PageParams pageParams){
        return articleService.listArticle(pageParams);
    }

    /**
     * 首页最热文章
     * @return
     */
    @PostMapping("hot")
    public Result hotArticle(){
        int limit  = 5;
        return articleService.hotArticle(limit);
    }
    /**
     * 首页最新文章
     * @return
     */
    @PostMapping("new")
    public Result newArticle(){
        int limit  = 5;
        return articleService.newArticle(limit);
    }

    /**
     * 文章归档
     * @return
     */
    @PostMapping("listArchives")
    public Result listArchives(){

        return articleService.listArchives();
    }
}
