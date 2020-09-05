package by.epamte.infohandler.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextFileReader {

    private final String FILE_PATH = "resources/text.txt";
    private final BufferedReader bufferedReader;

    public String readAll() throws IOException {

        StringBuilder builder = new StringBuilder();
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            builder.append(line).append("\n");
        }

        return builder.toString();
    }

    public TextFileReader() throws FileNotFoundException {

        FileReader fileReader = new FileReader(FILE_PATH);
        bufferedReader = new BufferedReader(fileReader);
    }

}
