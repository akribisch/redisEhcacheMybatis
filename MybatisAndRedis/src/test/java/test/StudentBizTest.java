package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.web.biz.StudentBiz;
import com.web.biz.impl.StudentBizImpl;
import com.web.entity.Student;

public class StudentBizTest {
	private StudentBiz sb=new StudentBizImpl();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testInsertStudent() {
		assertEquals(1, sb.insertStudent(new Student(0, "田十", 0, 33)));
	}

	@Test
	public void testUpdateStudent() {
		assertEquals(1, sb.updateStudent(new Student(2, "小九", 1, 20)));
	}

	@Test
	public void testDeleteStudent() {
		assertEquals(1, sb.deleteStudent(1));
	}

	@Test
	public void testFindAll() {
		assertEquals(4, sb.findAll().size());
	}

	@Test
	public void testFindById() {
		assertEquals(20, sb.findById(2).getStuAge());
	}

}
