package com.book.dao;

import com.book.entity.Book;
import com.book.entity.Borrow;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

public interface BookMapper {

    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "bid", property = "book_id"),
            @Result(column = "title", property = "book_name"),
            @Result(column = "lend_time", property = "lend_time"),
            @Result(column = "name", property = "student_name"),
            @Result(column = "sid", property = "student_id")
    })
    @Select("select * from borrow, student, book where borrow.bid = book.bid and student.sid = borrow.sid")
    List<Borrow> getBorrowList();

    @Select("select * from book")
    List<Book> getBookList();

    @Delete("delete from borrow where id = #{id}")
    void deleteBorrow(String id);

    @Insert("insert into borrow(bid, sid, lend_time) values(#{bid}, #{sid}, NOW())")
    boolean insertBorrow(@Param("bid") String bid, @Param("sid") String sid);


}
