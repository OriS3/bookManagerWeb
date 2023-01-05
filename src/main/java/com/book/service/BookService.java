package com.book.service;

import com.book.entity.Book;
import com.book.entity.Borrow;

import java.util.Date;
import java.util.List;

public interface BookService {

    /**
     * 获取借书列表
     * @return
     */
    List<Borrow> getBorrowList();

    /**
     * 还书方法
     * @param id
     */
    void returnBook(String id);

    /**
     * 获取书籍列表
     * @return
     */
    List<Book> getAllBooks();

    /**
     * 新增借书记录
     */
    boolean insertBorrow(String bid, String sid);
}
