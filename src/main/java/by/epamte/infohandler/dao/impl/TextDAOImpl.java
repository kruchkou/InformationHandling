package by.epamte.infohandler.dao.impl;

import by.epamte.infohandler.dao.TextDAO;
import by.epamte.infohandler.dao.TextFileReader;
import by.epamte.infohandler.dao.exception.DAOException;
import by.epamte.infohandler.entity.impl.Text;
import by.epamte.infohandler.parser.BookParser;
import by.epamte.infohandler.parser.ParserFactory;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TextDAOImpl implements TextDAO {

    private TextFileReader textFileReader;

    @Override
    public Text text() throws DAOException {
        String stringText = textFileReader.readAll();

        BookParser bookParser = ParserFactory.bookParser();
        Text text = bookParser.createText(stringText);

        return text;
    }

    public TextDAOImpl() throws DAOException {
            textFileReader = new TextFileReader();

    }

}
