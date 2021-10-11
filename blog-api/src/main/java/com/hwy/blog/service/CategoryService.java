package com.hwy.blog.service;

import com.hwy.blog.vo.CategoryVo;
import com.hwy.blog.vo.Result;

import java.util.List;

public interface CategoryService {
    CategoryVo findCategoryById(Long categoryId);

    Result findAll();

    Result findAllDetail();

    Result categoriesDetailById(Long id);
}
