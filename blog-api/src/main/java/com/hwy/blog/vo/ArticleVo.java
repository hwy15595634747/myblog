package com.hwy.blog.vo;

//import com.hwy.blog.dao.pojo.ArticleBody;
//import com.hwy.blog.dao.pojo.Category;

import com.hwy.blog.dao.pojo.SysUser;
import com.hwy.blog.dao.pojo.Tag;
import lombok.Data;

import java.util.List;

@Data
public class ArticleVo {

    private Long id;

    private String title;

    private String summary;

    private int commentCounts;

    private int viewCounts;

    private int weight;
    /**
     * 创建时间
     */
    private String createDate;

    private String author;

    // private ArticleBodyVo body;

    private List<TagVo> tags;

   // private List<CategoryVo> categorys;

}
