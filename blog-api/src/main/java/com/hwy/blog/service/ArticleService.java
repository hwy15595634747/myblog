package com.hwy.blog.service;

import com.hwy.blog.vo.Result;
import com.hwy.blog.vo.params.PageParams;

public interface ArticleService {
    /**
     * 分页查询文章列表
     * @param pageParams
     * @return
     */
    Result listArticle(PageParams pageParams);
}
