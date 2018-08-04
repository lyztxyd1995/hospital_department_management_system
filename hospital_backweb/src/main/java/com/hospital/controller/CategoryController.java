package com.hospital.controller;

import com.hospital.entity.Category;
import com.hospital.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller("categoryController")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Category>categories = categoryService.getAll();
        System.out.println(categories);
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/category.jsp").forward(request,response);
    }

    public void addPrompt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("/addCategory.jsp").forward(request,response);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name = request.getParameter("name");
        Category category = new Category();
        category.setName(name);
        categoryService.add(category);
        request.getRequestDispatcher("list.do").forward(request,response);
    }

    public void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Long id = Long.parseLong(request.getParameter("id"));
        Category category = categoryService.get(id);
        request.setAttribute("category", category);
        request.getRequestDispatcher("/editCategory.jsp").forward(request,response);
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        Category category = new Category();
        category.setName(name);
        category.setId(id);
        categoryService.edit(category);
        request.getRequestDispatcher("list.do").forward(request,response);
    }

    public void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Long id = Long.parseLong(request.getParameter("id"));
        categoryService.delete(id);
        request.getRequestDispatcher("list.do").forward(request,response);
    }
}
