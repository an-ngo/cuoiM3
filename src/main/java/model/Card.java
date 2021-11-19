package model;

import dao.book.BookDAO;
import dao.book.IBookDAO;
import dao.student.IStudentDAO;
import dao.student.StudentDAO;

public class Card {
    private int idCard;
    private int idBook;
    private int idStudent;
    private int status;
    private String borrowDate;
    private String returnDate;
    private Book book;
    private Student student;

    public Card(int idCard, int idBook, int idStudent, int status, String borrowDate, String returnDate) {
        IBookDAO bookDAO = new BookDAO();
        IStudentDAO studentDAO = new StudentDAO();
        this.idCard = idCard;
        this.idBook = idBook;
        this.idStudent = idStudent;
        this.status = status;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.student = studentDAO.findById(idStudent);
        this.book = bookDAO.findById(idBook);
    }
    public Card( int idBook, int idStudent, int status, String borrowDate, String returnDate) {
        IBookDAO bookDAO = new BookDAO();
        IStudentDAO studentDAO = new StudentDAO();
        this.idBook = idBook;
        this.idStudent = idStudent;
        this.status = status;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.student = studentDAO.findById(idStudent);
        this.book = bookDAO.findById(idBook);
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Card{" +
                "idCard=" + idCard +
                ", idBook=" + idBook +
                ", idStudent=" + idStudent +
                ", status=" + status +
                ", borrowDate='" + borrowDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                '}';
    }
}
