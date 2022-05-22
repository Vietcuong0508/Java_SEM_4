package com.example.t2009m1java.controller;

import com.example.t2009m1java.entity.Account;
import com.example.t2009m1java.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String currentName = req.getParameter("currentName");
//        req.setAttribute("currentName", currentName);
        List<Student> list = new ArrayList<>();
        Student student = new Student("A001", "Cuong", 1);
        list.add(student);
        Student student1 = new Student("A002", "Tran Cuong", 1);
        list.add(student1);
        req.setAttribute("list", list);
        req.getRequestDispatcher("/user/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
//        String confirmPassword = req.getParameter("confirmPassword");
        String fullName = req.getParameter("fullName");
        String phone = req.getParameter("phone");
        String birthday = req.getParameter("birthday");
        Account account = new Account();
        account.setUsername(username);
        account.setEmail(email);
        account.setPassword(password);
        account.setFullName(fullName);
        account.setPhone(phone);
        account.setBirthday(birthday);
        req.setAttribute("account", account);
        req.getRequestDispatcher("/user/register-success.jsp").forward(req, resp);
    }
}
