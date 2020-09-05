package by.epamte.infohandler;

import by.epamte.infohandler.dao.TextFileReader;
import by.epamte.infohandler.entity.impl.Text;
import by.epamte.infohandler.parser.BookParser;
import by.epamte.infohandler.parser.ParserFactory;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            TextFileReader reader = new TextFileReader();
            String textString = reader.readAll();

            BookParser bookParser = ParserFactory.bookParser();
            Text text = bookParser.createText(textString);

            System.out.println(text.value());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
