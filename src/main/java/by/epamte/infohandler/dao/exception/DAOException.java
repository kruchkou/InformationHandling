package by.epamte.infohandler.dao.exception;

import by.epamte.infohandler.dao.DAOFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;

public class DAOException extends IOException {

    private static final Logger logger = LogManager.getLogger(DAOException.class);

    public DAOException(String message) {
        super(message);
    }

    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOException(Throwable cause) {
        super(cause);
    }
}
