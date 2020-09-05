package by.epamte.infohandler.parser;

import by.epamte.infohandler.entity.impl.Digit;
import by.epamte.infohandler.entity.impl.PunctMark;
import by.epamte.infohandler.entity.impl.Sentence;
import by.epamte.infohandler.entity.impl.Word;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser {

    public Sentence parse(String stringText) {

        Pattern pattern = Pattern.compile(RegExps.partOfSentenceRegEx);
        Sentence sentence = new Sentence();
        Matcher matcher = pattern.matcher(stringText);

        while (matcher.find()) {

            String part = matcher.group().intern();
            if (part.matches(RegExps.wordRegEx)) {
                sentence.insertElement(new Word(part));
            } else if (part.matches(RegExps.digitRegEx)) {
                sentence.insertElement(new Digit(part));
            } else {
                sentence.insertElement(new PunctMark(part));
            }
        }

        return sentence;
    }
}
