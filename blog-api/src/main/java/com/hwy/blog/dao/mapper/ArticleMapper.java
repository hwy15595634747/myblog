package com.hwy.blog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hwy.blog.dao.dos.Archives;
import com.hwy.blog.dao.pojo.Article;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ArticleMapper extends BaseMapper<Article> {

    List<Archives>  listArchives();
}
