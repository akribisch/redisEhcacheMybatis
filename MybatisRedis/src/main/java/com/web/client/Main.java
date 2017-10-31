package com.web.client;

import com.web.dao.StudentDao;

import com.web.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by Administrator on 2017/10/24 0024.
 */
public class Main {

	private static SqlSessionFactory factory = null;
	private static Reader reader = null;

	public static void main(String[] args) {

		SqlSession session = factory.openSession();
		StudentDao sd = session.getMapper(StudentDao.class);//获取dao层
		System.out.println("one" + sd.findById(20));//首次查询数据，redis中没有相关数据
		System.out.println("two" + sd.findById(20));//未将数据提交，数据不可用，通过一级缓存获取数据
		session.commit();//提交数据，将数据存放到redis中
		System.out.println("three" + sd.findById(20));//从二级缓存中获取数据
		System.out.println("----------------again-----------------");
		SqlSession session1 = factory.openSession();
		StudentDao sd1 = session1.getMapper(StudentDao.class);
		System.out.println("FOUR" + sd1.findById(20));//从二级缓存中获取数据
//		sd.insertStudent(new Student(0, "十二", 0, 20));
//		session.commit();
//		sd.insertStudent(new Student(0, "十二", 0, 20));
//		session.commit();
//		sd.insertStudent(new Student(0, "十二", 0, 20));
//		session.commit();
//		sd.insertStudent(new Student(0, "十二", 0, 20));
//		session.commit();

	}

	static {
		try {
			reader = Resources.getResourceAsReader("mybatis_config.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
