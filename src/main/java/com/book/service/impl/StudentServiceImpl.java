package com.book.service.impl;

import com.book.dao.StudentMapper;
import com.book.dao.UserMapper;
import com.book.entity.Student;
import com.book.service.StudentService;
import com.book.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    @Override
    public List<Student> getAllStudent() {
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            return studentMapper.getAllStudent();
        }
    }
}
