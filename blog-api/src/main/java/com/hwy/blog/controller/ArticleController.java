package com.hwy.blog.controller;


import com.hwy.blog.common.aop.LogAnnotation;
import com.hwy.blog.common.cache.Cache;
import com.hwy.blog.service.ArticleService;
import com.hwy.blog.vo.Result;
import com.hwy.blog.vo.params.ArticleParam;
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
     *
     * @param pageParams
     * @return
     */
    @PostMapping
    //加上注解代表对此接口做日志
    @LogAnnotation(module = "文章", operation = "获取文章列表")
    //@Cache(expire = 5 * 60 * 1000, name = "list_article")
    public Result listArticle(@RequestBody PageParams pageParams) {
        return articleService.listArticle(pageParams);
    }

    /**
     * 首页最热文章
     *
     * @return
     */
    @PostMapping("hot")
    @Cache(expire = 5 * 60 * 1000, name = "hot_article")
    public Result hotArticle() {
        int limit = 5;

        return articleService.hotArticle(limit);
    }

    /**
     * 首页最新文章
     *
     * @return
     */
    @PostMapping("new")
    public Result newArticle() {
        int limit = 5;
        return articleService.newArticle(limit);
    }

    /**
     * 文章归档
     *
     * @return
     */
    @PostMapping("listArchives")
    public Result listArchives() {
        return articleService.listArchives();
    }

    @PostMapping("view/{id}")
    public Result findArticleById(@PathVariable("id") Long articleId) {
        return articleService.findArticleById(articleId);
    }

    @PostMapping("publish")
    public Result publish(@RequestBody ArticleParam articleParam) {
        return articleService.publish(articleParam);
    }

}
