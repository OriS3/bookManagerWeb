package com.book.service.impl;

import com.book.dao.BookMapper;
import com.book.dao.UserMapper;
import com.book.entity.Book;
import com.book.entity.Borrow;
import com.book.entity.User;
import com.book.service.BookService;
import com.book.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.List;

public class BookServiceImpl implements BookService {
    @Override
    public List<Borrow> getBorrowList() {
        try (SqlSession sqlSession = MybatisUtil.getSession();) {
            BookMapper mapper = sqlSession.getMapper(BookMapper.class);
            return  mapper.getBorrowList();
        }
    }

    @Override
    public void returnBook(String id) {
        try (SqlSession sqlSession = MybatisUtil.getSession();) {
            BookMapper mapper = sqlSession.getMapper(BookMapper.class);

            mapper.deleteBorrow(id);
        }
    }

    @Override
    public List<Book> getAllBooks() {
        try (SqlSession sqlSession = MybatisUtil.getSession();) {
            BookMapper mapper = sqlSession.getMapper(BookMapper.class);

            return mapper.getBookList();
        }
    }

    @Override
    public boolean insertBorrow(String bid, String sid) {
        try (SqlSession sqlSession = MybatisUtil.getSession();) {
            BookMapper mapper = sqlSession.getMapper(BookMapper.class);
            return mapper.insertBorrow(bid, sid);
        }
    }


}
