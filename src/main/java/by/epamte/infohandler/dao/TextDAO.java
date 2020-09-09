package by.epamte.infohandler.dao;

import by.epamte.infohandler.dao.exception.DAOException;
import by.epamte.infohandler.entity.impl.Text;

public interface TextDAO {

    Text text() throws DAOException;

}
