package com.web.biz.impl;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.web.biz.StudentBiz;
import com.web.dao.StudentDao;
import com.web.entity.Student;

public class StudentBizImpl implements StudentBiz {
	
	private static SqlSessionFactory factory=null;
    private static Reader reader=null;
    
    static {
        try {
            reader=Resources.getResourceAsReader("mybatis_config.xml");
            factory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private SqlSession session = factory.openSession();
    private StudentDao sd=session.getMapper(StudentDao.class);

	public int insertStudent(Student student) {
		int result=sd.insertStudent(student);
		session.commit();
		return result;
	}

	public int updateStudent(Student student) {
		int result=sd.updateStudent(student);
		session.commit();
		return result;
	}

	public int deleteStudent(int stuNo) {
		int result=sd.deleteStudent(stuNo);
		session.commit();
		return result;
	}

	public List<Student> findAll() {
		return sd.findAll();
	}

	public Student findById(int stuNo) {
		return sd.findById(stuNo);
	}

}
