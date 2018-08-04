package com.hospital.service;

import com.hospital.entity.Dept;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DeptService {
     void add(Dept dept);
     void edit(Dept dept);
     void delete(Long id);
     List<Dept> getByCategoryId(Long id);
     Dept getById(Long id);
}
