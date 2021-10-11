package com.hwy.blog.controller;

import com.hwy.blog.service.TagService;
import com.hwy.blog.vo.Result;
import com.hwy.blog.vo.TagVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("tags")
public class TagsController {
    @Autowired
    private TagService tagService;

    /**
     * 最热标签
     * @return
     */
    @GetMapping("/hot")
    public Result hot(){
        int limit = 3;
        return tagService.listHots(limit);
    }

    @GetMapping
    public Result findAll(){
        return tagService.findAll();
    }

    @GetMapping("/detail")
    public Result findAllDetail(){
        return tagService.findAllDetail();
    }

    @GetMapping("/detail/{id}")
    public Result findAllDetailById(@PathVariable("id") Long id){
        return tagService.findAllDetailById(id);
    }

}
