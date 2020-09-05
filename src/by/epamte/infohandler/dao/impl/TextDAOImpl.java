package by.epamte.infohandler.dao.impl;

import by.epamte.infohandler.dao.TextDAO;
import by.epamte.infohandler.dao.TextFileReader;
import by.epamte.infohandler.entity.impl.Text;

import java.io.IOException;

public class TextDAOImpl implements TextDAO {

    private final TextFileReader textFileReader;

    @Override
    public Text text() throws IOException {
        return null;
    }

    public TextDAOImpl() throws IOException {

        textFileReader = new TextFileReader();
    }

}
