package by.epamte.infohandler.dao;

import by.epamte.infohandler.dao.impl.TextDAOImpl;

import java.io.IOException;

public final class DAOFactory {

    private static DAOFactory instance = new DAOFactory();
    private TextDAO textDAO;

    private DAOFactory() {}

    public TextDAO getApplianceDAO() throws IOException {
        TextDAO textDAO= new TextDAOImpl();
        return textDAO;
    }

    public static DAOFactory getInstance() {
        return new DAOFactory();
    }
}
