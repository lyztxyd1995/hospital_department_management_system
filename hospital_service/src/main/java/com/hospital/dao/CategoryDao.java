package com.hospital.dao;

import com.hospital.entity.Category;

import java.util.List;

public interface CategoryDao {
    public void insert(Category category);
    public void update(Category category);
    public void delete(Long id);
    public Category selectById(Long id);
    public List<Category> selectAll();
}
