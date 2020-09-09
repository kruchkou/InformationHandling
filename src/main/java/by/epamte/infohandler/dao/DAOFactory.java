package by.epamte.infohandler.dao;

import by.epamte.infohandler.dao.exception.DAOException;
import by.epamte.infohandler.dao.impl.TextDAOImpl;

public final class DAOFactory {

    private static final DAOFactory instance = new DAOFactory();
    private TextDAO textDAO;

    private DAOFactory() {
    }

    public TextDAO textDAO() throws DAOException {
        if (textDAO == null) {
            textDAO = new TextDAOImpl();
        }
        return textDAO;
    }

    public static DAOFactory getInstance() {
        return instance;
    }
}
