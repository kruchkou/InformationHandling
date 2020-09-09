package by.epamte.infohandler.parser;

import by.epamte.infohandler.dao.exception.DAOException;
import by.epamte.infohandler.entity.impl.Digit;
import by.epamte.infohandler.entity.impl.PunctMark;
import by.epamte.infohandler.entity.impl.Sentence;
import by.epamte.infohandler.entity.impl.Word;
import by.epamte.infohandler.util.RegexPropertyUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser {

    public Sentence parse(String stringText) throws DAOException {

        RegexPropertyUtil regexPropertyUtil = RegexPropertyUtil.getInstance();
        Pattern pattern = Pattern.compile(regexPropertyUtil.getProperty("partOfSentenceRegEx"));
        Sentence sentence = new Sentence();
        Matcher matcher = pattern.matcher(stringText);

        while (matcher.find()) {

            String part = matcher.group().intern();
            if (part.matches(regexPropertyUtil.getProperty("wordRegEx"))) {
                sentence.insertElement(new Word(part));
            } else if (part.matches(regexPropertyUtil.getProperty("digitRegEx"))) {
                sentence.insertElement(new Digit(part));
            } else {
                sentence.insertElement(new PunctMark(part));
            }
        }

        //sentence.insertElement(new PunctMark(" "));
        return sentence;
    }
}
