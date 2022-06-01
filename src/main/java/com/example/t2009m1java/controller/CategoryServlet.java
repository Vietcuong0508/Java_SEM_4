package com.example.t2009m1java.controller;

import com.example.t2009m1java.entity.Account;
import com.example.t2009m1java.entity.Category;
import com.example.t2009m1java.model.CategoryModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CategoryServlet extends HttpServlet {
    private CategoryModel categoryModel;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/admin/demo/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        // lấy giá trị từ form gửi lên.
        String name = req.getParameter("name");
        // Khởi tạo đối tượng account từ thông tin truyền lên.
        Category category = Category.CategoryBuilder.aCategory()
                .withName(name)
                .build();
        if(!category.isValid()){
            // trả dữ liệu cũ về form
            req.setAttribute("category", category);
            // kèm theo thông tin lỗi
//            req.setAttribute("errors", category.getErrors());
            // tất cả được trả về
            req.getRequestDispatcher("/admin/demo/form.jsp").forward(req, resp);
            return;
        }
        // thực hiện save
        categoryModel.save(category);
        req.setAttribute("category", category);
        req.getRequestDispatcher("/user/register-success.jsp").forward(req, resp);
    }
}
