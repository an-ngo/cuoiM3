package dao.card;

import model.Card;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CardDAO implements ICardDAO{
    final String ADD_CARD = "insert into kiemtra.card(idBook, idStudent, status, borrowDate, returnDate) VALUE (?,?,?,?,?);";
    final String FIND_ALL = "select * from kiemtra.card";
    final String DELETE_BY_ID = "delete from kiemtra.card where idCard = ?";
    final String RETURN_BOOK = "update kiemtra.card set status = 1 where idCard =?";

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
    public List<Card> findAll() {
        List<Card> list = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idCard = rs.getInt(1);
                int idBook = rs.getInt(2);
                int idStudent = rs.getInt(3);
                int status = rs.getInt(4);
                String borrowDate = rs.getString(5);
                String returnDate = rs.getString(6);

                list.add(new Card(idCard, idBook, idStudent, status, borrowDate,returnDate));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public void add(Card card) {
        Connection connection = getConnection();
        try {

            PreparedStatement ps = connection.prepareStatement(ADD_CARD);
            ps.setInt(1, card.getIdBook());
            ps.setInt(2, card.getIdStudent());
            ps.setInt(3, card.getStatus());
            ps.setString(4, card.getBorrowDate());
            ps.setString(5, card.getReturnDate());


            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    @Override
    public Card findById(int id) {
        return null;
    }

    @Override
    public void update(int id, Card card) {

    }

    @Override
    public void remove(int id) {
        try {
            PreparedStatement ps = getConnection().prepareStatement(DELETE_BY_ID);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean returnBook(int idCard) {
        boolean result = false;
        try {
            PreparedStatement ps = getConnection().prepareStatement(RETURN_BOOK);
            ps.setInt(1,idCard);
            result= ps.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  result;
    }
}
