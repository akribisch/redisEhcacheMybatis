package com.web.dao;

import com.web.entity.Student;

import java.util.List;


/**
 * Created by Administrator on 2017/10/24 0024.
 */

public interface StudentDao {

    /**
     * 添加学生
     * @param student 学生信息
     * @return 成功添加一条数据返回1
     */
    public int insertStudent(Student student);

    /**
     * 修改学生
     * @param student 修改后的学生
     * @return 修改成功返回1
     */
    public int updateStudent(Student student);

    /**
     * 删除学生
     * @param stuNo 删除的学生编号
     * @return 删除成功为1
     */
    public int deleteStudent(int stuNo);

    /**
     * 全部查询学生
     * @return 返回学生的集合
     */
    public List<Student> findAll();

    /**
     * 通过编号查找对应的学生
     * @param stuNo 学生编号
     * @return 返回唯一的学生
     */
    public Student findById(int stuNo);
}
