package dao.book;
import model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO implements IBookDAO{
    public static final String FIND_ALL = "select * from kiemtra.book";
    public static final String FIND_BOOK_BY_ID = "select * from kiemtra.book where book.idBook = ?;";
    static final String DECREASE_VALUE_BOOK = "update kiemtra.book set value = ? where idBook = ?";

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
    public List<Book> findAll() {
            List<Book> list = new ArrayList<>();
            try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL)) {
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    int idBook = rs.getInt(1);
                    String name = rs.getString(2);
                    String author = rs.getString(3);
                    String description = rs.getString(4);
                    int value = rs.getInt(5);

                    list.add(new Book(idBook, name, author, description, value));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return list;
    }

    @Override
    public void add(Book book) {

    }

    @Override
    public Book findById(int id) {
        Book book = null;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(FIND_BOOK_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idBook = rs.getInt(1);
                String name = rs.getString(2);
                String author = rs.getString(3);
                String description = rs.getString(4);
                int value = rs.getInt(5);
                book = new Book(idBook, name, author, description, value);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return book;
    }

    @Override
    public void update(int id, Book book) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public boolean decreaseValueBook(int idBook) {
        int value = findById(idBook).getValue();
        boolean result = false;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DECREASE_VALUE_BOOK)) {
            preparedStatement.setInt(1, --value);
            preparedStatement.setInt(2, idBook);
            result = preparedStatement.executeUpdate()>0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
}
