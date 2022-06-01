package com.example.t2009m1java.controller;

import com.example.t2009m1java.entity.Product;
import com.example.t2009m1java.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductServlet extends HttpServlet {
    private ProductModel productModel;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/admin/products/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        // lấy giá trị từ form gửi lên.
        String name = req.getParameter("name");
        String thumbnail = req.getParameter("thumbnail");
        Double price = Double.valueOf(req.getParameter("price"));
        int categoryId = Integer.parseInt(req.getParameter("categoryId"));
        String description = req.getParameter("description");
        // Khởi tạo đối tượng account từ thông tin truyền lên.
        Product product = Product.ProductBuilder.aProduct()
                .withName(name)
                .withThumbnail(thumbnail)
                .withPrice(price)
                .withCategoryId(categoryId)
                .withDescription(description)
                .build();
        if(!product.isValid()){
            // trả dữ liệu cũ về form
            req.setAttribute("product", product);
            // kèm theo thông tin lỗi
//            req.setAttribute("errors", category.getErrors());
            // tất cả được trả về
            req.getRequestDispatcher("/admin/products/form.jsp").forward(req, resp);
            return;
        }
        // thực hiện save
        productModel.save(product);
        req.setAttribute("product", product);
        req.getRequestDispatcher("/user/register-success.jsp").forward(req, resp);
    }
}
