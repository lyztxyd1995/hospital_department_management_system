package com.hospital.dao;

import com.hospital.entity.Dept;

import java.util.List;

public interface DeptDao {
     void insert(Dept dept);
     void update(Dept dept);
     void delete(Long id);
     List<Dept>selectByCategoryId(Long id);
     Dept selectById(Long id);
}
