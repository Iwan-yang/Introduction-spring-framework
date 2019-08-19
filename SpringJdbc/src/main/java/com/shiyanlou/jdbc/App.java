package com.shiyanlou.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import com.shiyanlou.jdbc.entity.Student;
import java.util.List;

public class App {
    private static ApplicationContext context;

    public static void main(String[] args) {
        context = new ClassPathXmlApplicationContext("SpringBeans.xml");

        JdbcTemplate jdbcTemplate=(JdbcTemplate) context.getBean("jdbcTemplate");

        // 新增
        String insertsql="insert into student values(?,?,?)";
        int insert=jdbcTemplate.update(insertsql,new Object[]{2,"shiyanlou2",18});
        System.out.println("新增编号为2的学生信息："+ insert);

        // 删除
        String deleteSql="delete from student where id=?";
        int delete=jdbcTemplate.update(deleteSql,2);
        System.out.println("删除编号为2的学生信息："+ delete);

        // 修改
        String updateSql="update student set name=?,age=? where id=?";
        int update=jdbcTemplate.update(updateSql,new Object[]{"shiyanlou1",20,1});
        System.out.println("修改编号为1的学生信息："+update);

        // 查询
        String selectSql="select * from student";

        RowMapper<Student> rowMapper=new BeanPropertyRowMapper<Student>(Student.class);
        // Student student=jdbcTemplate.queryForObject(selectSql,rowMapper);
        // System.out.println(student);

        List<Student> students=jdbcTemplate.query(selectSql,rowMapper);
        for(Student student:students){
            System.out.println(student);
        }

    }
}