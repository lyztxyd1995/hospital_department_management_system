package com.hospital.service.impl;

import com.hospital.dao.DeptDao;
import com.hospital.entity.Dept;
import com.hospital.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("deptService")
public class DeptServiceImpl implements DeptService {

    @Autowired
    DeptDao deptDao;
    public void add(Dept dept) {
        dept.setCreate_time(new Date());
        dept.setUpdate_time(new Date());
        deptDao.insert(dept);
    }

    public void edit(Dept dept) {
        dept.setUpdate_time(new Date());
        deptDao.update(dept);
    }

    public void delete(Long id) {
        deptDao.delete(id);
    }

    public List<Dept> getByCategoryId(Long id) {
        return deptDao.selectByCategoryId(id);
    }

    public Dept getById(Long id) {
        return deptDao.selectById(id);
    }
}
