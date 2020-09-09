package by.epamte.infohandler.util;

import by.epamte.infohandler.dao.exception.DAOException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class RegexPropertyUtil {

    private static RegexPropertyUtil instance;
    private static final Properties properties = new Properties();

    private RegexPropertyUtil() {}

    public static RegexPropertyUtil getInstance() throws DAOException {
        if(instance == null) {
            instance = new RegexPropertyUtil();

            try {
                FileInputStream fileInputStream = new FileInputStream("resources/regex.properties");
                properties.load(fileInputStream);
            } catch (FileNotFoundException e) {
                throw new DAOException("Can't reach regex.properties",e);
            } catch (IOException e) {
                throw new DAOException("Cant read regex.properties",e);
            }

        }

        return instance;
    }

    public String getProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }

}
