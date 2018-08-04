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

@Controller("selfController")
public class SelfController {
    @Autowired
    CategoryService categoryService;
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Category> categories = categoryService.getAll();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/home_detail.jsp").forward(request,response);
    }
}
