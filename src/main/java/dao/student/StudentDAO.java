package dao.student;

import model.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IStudentDAO{
    public static final String FIND_ALL = "select * from kiemtra.student";
    final String FIND_BY_ID = "select * from kiemtra.student where idStudent = ?;";


    private String jdbcURL = "jdbc:mysql://localhost:3306/kiemtra?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456a@A";

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            System.out.println("ket noi thanh cong");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Ket noi khong thanh cong");
        }
        return connection;
    }

    @Override
    public List<Student> findAll() {
        List<Student> list = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idStudent = rs.getInt(1);
                String name = rs.getString(2);
                String className = rs.getString(3);


                list.add(new Student(idStudent, name, className));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public void add(Student student) {

    }

    @Override
    public Student findById(int id) {
        Student student = null;
        try {
            PreparedStatement ps = getConnection().prepareStatement(FIND_BY_ID);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int idStudent = rs.getInt(1);
                String name = rs.getString(2);
                String className = rs.getString(3);

                student = new Student(idStudent,name,className);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public void update(int id, Student student) {

    }

    @Override
    public void remove(int id) {

    }
}
