package com.example.t2009m1java.controller;

import com.example.t2009m1java.entity.Account;
import com.example.t2009m1java.entity.Student;
import com.example.t2009m1java.model.AccountModel;
import com.example.t2009m1java.model.MySqlAccountModel;
import com.example.t2009m1java.util.ConnectionHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegisterServlet extends HttpServlet {
    private AccountModel accountModel;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String currentName = req.getParameter("currentName");
//        req.setAttribute("currentName", currentName);
//        List<Student> list = new ArrayList<>();
//        Student student = new Student("A001", "Cuong", 1);
//        list.add(student);
//        Student student1 = new Student("A002", "Tran Cuong", 1);
//        list.add(student1);
//        req.setAttribute("list", list);

        String action = req.getServletPath();
        switch (action) {
            case "/register":
                register(req, resp);
                break;
            case "create":
                create(req, resp);
                break;
            case "delete":
                delete(req, resp);
                break;
            case "edit":
                edit(req, resp);
                break;
            case "update":
                update(req, resp);
                break;
            default:
                list(req, resp);
                break;
        }
    }

    private void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/user/register.jsp");
        dispatcher.forward(req, resp);
    }

    private void create(HttpServletRequest req, HttpServletResponse resp) throws  ServletException, IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String fullName = req.getParameter("fullName");
        String phone = req.getParameter("phone");
        String birthday = req.getParameter("birthday");
        Account account = new Account(username, email, password, fullName, phone, birthday);
        accountModel.save(account);
        resp.sendRedirect("list");
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws  ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            accountModel.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("list");
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws  ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Account exitAccount;

        try {
            exitAccount = accountModel.findById(id);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/user/register.jsp");
            req.setAttribute("account", exitAccount);
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("list");
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws  ServletException, IOException {
//        int id = Integer.parseInt(req.getParameter("id"));
//        String username = req.getParameter("username");
//        String email = req.getParameter("email");
//        String password = req.getParameter("password");
//        String fullName = req.getParameter("fullName");
//        String phone = req.getParameter("phone");
//        String birthday = req.getParameter("birthday");
//        int status = Integer.parseInt(req.getParameter("status"));
//        Account account = new Account(id, username, email, password, fullName, phone, birthday, status);
//        accountModel.update(account);
        resp.sendRedirect("list");
    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws  ServletException, IOException {
        try {
            List<Account> list = accountModel.findAll();
            req.setAttribute("list", list);
            RequestDispatcher dispatcher = req.getRequestDispatcher("list.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
