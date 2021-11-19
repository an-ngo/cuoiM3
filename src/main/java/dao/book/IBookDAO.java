package dao.book;

import dao.IDao;
import model.Book;


public interface IBookDAO extends IDao<Book> {
    boolean decreaseValueBook(int idBook);
}
