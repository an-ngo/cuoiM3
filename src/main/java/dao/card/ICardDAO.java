package dao.card;

import dao.IDao;
import model.Card;

public interface ICardDAO extends IDao<Card> {
    boolean returnBook(int idCard);
}
