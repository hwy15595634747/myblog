package com.hwy.blog.service;

import com.hwy.blog.vo.Result;
import com.hwy.blog.vo.params.ArticleParam;
import com.hwy.blog.vo.params.PageParams;



public interface ArticleService {
    /**
     * 分页查询文章列表
     * @param pageParams
     * @return
     */
    Result listArticle(PageParams pageParams);

    /**
     * 最热文章接口
     * @param limit
     * @return
     */
    Result hotArticle(int limit);

    Result newArticle(int limit);

    /**
     * 文章归档
     * @return
     */
    Result listArchives();

    Result findArticleById(Long articleId);

    /**
     * 文章发布服务
     * @param articleParam
     * @return
     */
    Result publish(ArticleParam articleParam);
}
