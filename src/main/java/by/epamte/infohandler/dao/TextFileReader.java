package by.epamte.infohandler.dao;

import by.epamte.infohandler.dao.exception.DAOException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextFileReader {

    private final String FILE_PATH = "resources/text.txt";
    private final BufferedReader bufferedReader;

    public String readAll() throws DAOException {

        StringBuilder builder = new StringBuilder();
        String line;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                builder.append(line).append("\n");
            }

        } catch (IOException e) {
            throw new DAOException("File can't be read!", e);
        }
        return builder.toString();
    }

    public TextFileReader() throws DAOException {

        FileReader fileReader;
        try {
            fileReader = new FileReader(FILE_PATH);
        } catch (FileNotFoundException e) {
            throw new DAOException("File not founded!", e);
        }
        bufferedReader = new BufferedReader(fileReader);
    }

}
