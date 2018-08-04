package com.hospital.controller;

import com.hospital.entity.Category;
import com.hospital.entity.Dept;
import com.hospital.service.CategoryService;
import com.hospital.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller("deptController")
public class DeptController {
    @Autowired
    DeptService deptService;

    @Autowired
    private CategoryService categoryService;

    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String categoryIdStr = request.getParameter("category_id");
        Long category_id = (long)1;
        if((categoryIdStr != null) && (!"".equals(categoryIdStr.trim()))){
            category_id = Long.parseLong(categoryIdStr);
        }
        List<Dept>depts = deptService.getByCategoryId(category_id);
        request.setAttribute("depts", depts);
        List<Category>categories = categoryService.getAll();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
    public void addPrompt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Category>categories = categoryService.getAll();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/addDept.jsp").forward(request,response);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name = request.getParameter("name");
        Long category_id = Long.parseLong(request.getParameter("categoryId"));
        Dept dept = new Dept();
        dept.setCategory_id(category_id);
        dept.setName(name);
        deptService.add(dept);
        request.setAttribute("category_id", category_id);
        request.getRequestDispatcher("list.do").forward(request,response);
    }

    public void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Long id = Long.parseLong(request.getParameter("id"));
        Dept dept = deptService.getById(id);
        List<Category>categories = categoryService.getAll();
        request.setAttribute("categories", categories);
        request.setAttribute("dept", dept);
        request.getRequestDispatcher("/editDept.jsp").forward(request,response);
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        Long category_id = Long.parseLong(request.getParameter("categoryId"));
        Dept dept = new Dept();
        dept.setId(id);
        dept.setName(name);
        dept.setCategory_id(category_id);
        deptService.edit(dept);
        request.setAttribute("category_id", category_id);
        request.getRequestDispatcher("list.do").forward(request,response);
    }

    public void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Long id = Long.parseLong(request.getParameter("id"));
        Dept dept = deptService.getById(id);
        Long category_id = dept.getCategory_id();
        deptService.delete(id);
        request.setAttribute("category_id", category_id);
        request.getRequestDispatcher("list.do").forward(request,response);
    }

}
