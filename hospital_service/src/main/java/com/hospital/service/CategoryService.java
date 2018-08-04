package com.hospital.service;

import com.hospital.entity.Category;

import java.util.List;

public interface CategoryService {
    public void add(Category category);
    public void edit(Category category);
    public void delete(Long id);
    public Category get(Long id);
    public List<Category> getAll();
}
