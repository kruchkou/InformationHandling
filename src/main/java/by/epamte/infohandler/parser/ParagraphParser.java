package by.epamte.infohandler.parser;

import by.epamte.infohandler.dao.exception.DAOException;
import by.epamte.infohandler.entity.TextElement;
import by.epamte.infohandler.entity.impl.Sentence;
import by.epamte.infohandler.util.RegexPropertyUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser {

    public List<TextElement> parse(String stringText) throws DAOException {

        ParserFactory parserFactory = new ParserFactory();
        RegexPropertyUtil regexPropertyUtil = RegexPropertyUtil.getInstance();

        Pattern pattern = Pattern.compile(regexPropertyUtil.getProperty("sentenceRegEx"));
        List<TextElement> paragraph = new ArrayList<>();
        SentenceParser sentenceParser = ParserFactory.sentenceParser();

        Matcher matcher = pattern.matcher(stringText);

        while (matcher.find()) {
            //StringBuilder builder = new StringBuilder();

            String sentenceString = matcher.group();
            //sentenceString = sentenceString.trim();
            Sentence sentence = sentenceParser.parse(sentenceString);

            paragraph.add(sentence);
        }
        return paragraph;
    }

}
