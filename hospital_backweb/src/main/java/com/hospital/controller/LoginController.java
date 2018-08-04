package com.hospital.controller;

import com.hospital.entity.Category;
import com.hospital.entity.Dept;
import com.hospital.entity.User;
import com.hospital.service.CategoryService;
import com.hospital.service.DeptService;
import com.hospital.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller("loginController")
public class LoginController {
    @Autowired
    private LoginService loginService;

    public void toLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = loginService.login(username,password);
        if(user == null){
            response.sendRedirect("toLogin.do");
        } else {
            request.getSession().setAttribute("User", user);
            response.sendRedirect("/dept/list.do");
        }
    }
}
