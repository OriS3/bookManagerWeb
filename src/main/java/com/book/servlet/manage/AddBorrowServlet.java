package com.book.servlet.manage;

import com.book.entity.Book;
import com.book.service.BookService;
import com.book.service.StudentService;
import com.book.service.impl.BookServiceImpl;
import com.book.service.impl.StudentServiceImpl;
import com.book.utils.ThymeleafUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.context.Context;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/add-borrow")
public class AddBorrowServlet extends HttpServlet {
    StudentService studentService;
    BookService bookService;


    @Override
    public void init() throws ServletException {
        studentService = new StudentServiceImpl();
        bookService = new BookServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context = new Context();
        List studentList = studentService.getAllStudent();
        List<Book> bookList = bookService.getAllBooks();

        System.out.println(Arrays.toString(bookList.toArray()));
        System.out.println(Arrays.toString(studentList.toArray()));
        context.setVariable("studentList", studentList);
        context.setVariable("bookList", bookList);

        ThymeleafUtil.process("add-borrow.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context = new Context();

        String bid = req.getParameter("bid");
        String sid = req.getParameter("sid");
        boolean b = false;
        try {
            b = bookService.insertBorrow(bid, sid);
        } catch (Exception e) {

        }
        if (b) {
            resp.sendRedirect("index");
        } else {
            resp.sendRedirect("add-borrow");

        }

    }

}
