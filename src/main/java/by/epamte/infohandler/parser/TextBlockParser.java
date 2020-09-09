package by.epamte.infohandler.parser;

import by.epamte.infohandler.dao.exception.DAOException;
import by.epamte.infohandler.entity.TextElement;
import by.epamte.infohandler.entity.impl.PunctMark;
import by.epamte.infohandler.entity.impl.Sentence;
import by.epamte.infohandler.util.RegexPropertyUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextBlockParser {

    public List<TextElement> parse(String stringText) throws DAOException {
        List<TextElement> textPart = new ArrayList<>();

        ParagraphParser paragraphParser = ParserFactory.paragraphParser();
        RegexPropertyUtil regexPropertyUtil = RegexPropertyUtil.getInstance();

        Pattern pattern = Pattern.compile(regexPropertyUtil.getProperty("paragraphRegEx"));
        Matcher matcher = pattern.matcher(stringText);

        while (matcher.find()) {
            String paragraphString = matcher.group();

            if (paragraphString != null) {
                List<TextElement> paragraph = paragraphParser.parse(paragraphString);

                if(paragraph.size()>0) {

                    Sentence lastSentence = (Sentence) paragraph.get(paragraph.size() - 1);
                    lastSentence.insertElement(new PunctMark("\n"));

                    textPart.addAll(paragraph);
                }
            }
        }
        return textPart;
    }
}
