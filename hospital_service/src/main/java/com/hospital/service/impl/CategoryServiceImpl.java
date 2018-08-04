package com.hospital.service.impl;


import com.hospital.dao.CategoryDao;
import com.hospital.entity.Category;
import com.hospital.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryDao categoryDao;
    public void add(Category category) {
        category.setCreate_time(new Date());
        category.setUpdate_time(new Date());
        categoryDao.insert(category);
    }

    public void edit(Category category) {
        category.setUpdate_time(new Date());
        categoryDao.update(category);
    }

    public void delete(Long id) {
        categoryDao.delete(id);
    }

    public Category get(Long id) {
        return categoryDao.selectById(id);
    }

    public List<Category> getAll() {
        return categoryDao.selectAll();
    }
}
