package com.book.servlet.manage;

import com.book.service.BookService;
import com.book.service.impl.BookServiceImpl;
import com.book.utils.MybatisUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/return-book")
public class ReturnServlet extends HttpServlet {
    BookService service;

    @Override
    public void init() throws ServletException {
        service = new BookServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        // 归还操作
        service.returnBook(id);


        // 重定向操作
        resp.sendRedirect("index");




    }
}


