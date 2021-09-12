package com.hwy.blog.service;

import com.hwy.blog.vo.Result;
import com.hwy.blog.vo.TagVo;

import java.util.List;

public interface TagService {
    List<TagVo> findTagsByArticledId(Long articleId);

    Result listHots(int limit);
}
