package com.hwy.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hwy.blog.dao.mapper.TagMapper;
import com.hwy.blog.dao.pojo.Tag;
import com.hwy.blog.service.TagService;
import com.hwy.blog.vo.Result;
import com.hwy.blog.vo.TagVo;
import javafx.scene.control.Tab;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;


    public TagVo copy(Tag tag){
        TagVo tagVo = new TagVo();
        BeanUtils.copyProperties(tag,tagVo);
        return tagVo;
    }

    public List<TagVo> copyList(List<Tag> tagList){
        List<TagVo> tagVoList = new ArrayList<>();
        for (Tag tag : tagList) {
            tagVoList.add(copy(tag));
        }
        return tagVoList;
    }

    @Override
    public List<TagVo> findTagsByArticledId(Long articleId) {
        //mybatisplus 无法进行多表查询
        List<Tag> tags = tagMapper.findTagsByArticleId(articleId);
        return copyList(tags);
    }



    @Override
    public Result listHots(int limit) {
        /**
         * 1. 标签所拥有的文章数量最多
         * 2. 查询 根据tag_id分组计数，从大到小排序，取前limit个
         */
        List<Long> tagIds= tagMapper.findHotsTagIds(limit);
        if(CollectionUtils.isEmpty(tagIds)){
            return Result.success(Collections.emptyList());
        }
        List<Tag>  tagList = tagMapper.findTagsByTagIds(tagIds);
        List<TagVo> tagVoList = copyList(tagList);
        return Result.success(tagVoList);
    }

    @Override
    public Result findAll() {
        LambdaQueryWrapper<Tag> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.select(Tag::getId,Tag::getTagName);
        List<Tag> tagList = this.tagMapper.selectList(queryWrapper);
        return Result.success(copyList(tagList));
    }

    @Override
    public Result findAllDetail() {
        List<Tag> tagList = this.tagMapper.selectList(new LambdaQueryWrapper<>());
        List<TagVo> tagVoList = copyList(tagList);
        return Result.success(tagVoList);
    }

    @Override
    public Result findAllDetailById(Long id) {
        Tag tag = tagMapper.selectById(id);
        return Result.success(copy(tag));
    }


}
