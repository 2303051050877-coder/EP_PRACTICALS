package com.practical.spring.dao;

import com.practical.spring.entity.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveStudent(Student student) {
        String sql = "INSERT INTO students (name, email) VALUES (?, ?)";
        jdbcTemplate.update(sql, student.getName(), student.getEmail());
    }

    @SuppressWarnings("deprecation")
	@Override
    public Student getStudent(int id) {
        String sql = "SELECT * FROM students WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new StudentRowMapper());
    }

    @Override
    public List<Student> getAllStudents() {
        String sql = "SELECT * FROM students";
        return jdbcTemplate.query(sql, new StudentRowMapper());
    }

    @Override
    public void updateStudent(Student student) {
        String sql = "UPDATE students SET name=?, email=? WHERE id=?";
        jdbcTemplate.update(sql, student.getName(), student.getEmail(), student.getId());
    }

    @Override
    public void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    // RowMapper for Student
    private static class StudentRowMapper implements RowMapper<Student> {
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setEmail(rs.getString("email"));
            return student;
        }
    }
}
