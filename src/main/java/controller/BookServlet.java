package controller;

import dao.book.BookDAO;
import dao.book.IBookDAO;
import dao.card.CardDAO;
import dao.card.ICardDAO;
import dao.student.IStudentDAO;
import dao.student.StudentDAO;
import model.Book;
import model.Card;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookServlet", value = "/books")
public class BookServlet extends HttpServlet {
    IBookDAO bookDAO = new BookDAO();
    IStudentDAO studentDAO = new StudentDAO();
    ICardDAO cardDAO = new CardDAO();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "borrow":
                showBorrowCardForm(request, response);
                break;
            case "showAllCard":
                showAllCard(request, response);
                break;
            case "returnBook":
                returnBook(request,response);
                break;
            default:
                showAllBook(request, response);

        }
    }

    private void returnBook(HttpServletRequest request, HttpServletResponse response) {
        int idCard = Integer.parseInt(request.getParameter("idCard"));
        boolean check = cardDAO.returnBook(idCard);
        if(check){
            showAllCard(request,response);
        }else{
            popOutError("khong the tra",request,response);
        }

    }

    private void showAllCard(HttpServletRequest request, HttpServletResponse response) {
        List<Card> listCard = cardDAO.findAll();

        request.setAttribute("listCard", listCard);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("showAllCard.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showBorrowCardForm(HttpServletRequest request, HttpServletResponse response) {
        int idBook = Integer.parseInt(request.getParameter("idBook"));
        Book book = bookDAO.findById(idBook);

        if(book.getValue()>0){
            request.setAttribute("book",book);
            request.setAttribute("listStudent",studentDAO.findAll());
            RequestDispatcher dispatcher = request.getRequestDispatcher("showCardForm.jsp");
            try {
                dispatcher.forward(request,response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
        else {
            popOutError("Sach nay da het",request,response);
        }

    }






    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "borrow":
                createCard(request, response);
                break;
            case "showAllCard":
                showAllCard(request, response);
                break;
            case "showAllCardNotReturn":
                showAllCardNotReturn(request, response);
                break;
            default:
                showAllBook(request, response);

        }

    }

    private void showAllCardNotReturn(HttpServletRequest request, HttpServletResponse response) {
        List<Card> listCard = cardDAO.findAll();

        request.setAttribute("listCard", listCard);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("showAllCardNotReturn.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createCard(HttpServletRequest request, HttpServletResponse response) {

        int idStudent = Integer.parseInt(request.getParameter("idStudent"));
        int idBook = Integer.parseInt(request.getParameter("idBook"));
        String borrowDate = request.getParameter("borrowDate");
        String returnDate = request.getParameter("returnDate");
        Card card = new Card(idBook,idStudent,0,borrowDate,returnDate);
        boolean check = bookDAO.decreaseValueBook(idBook);
        if(check){
            cardDAO.add(card);
            showAllBook(request,response);
        }else{
            popOutError("Khong The Muon Sach",request,response);
        }
    }


    private void showAllBook(HttpServletRequest request, HttpServletResponse response) {
        List<Book> listBook = bookDAO.findAll();
        request.setAttribute("listBook", listBook);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("showAllBook.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }


    private void popOutError(String message,HttpServletRequest request, HttpServletResponse response){
        request.setAttribute("message",message);
        RequestDispatcher dispatcher = request.getRequestDispatcher("noBookAlert.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}


