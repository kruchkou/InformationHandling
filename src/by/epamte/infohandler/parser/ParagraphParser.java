package by.epamte.infohandler.parser;

import by.epamte.infohandler.entity.impl.Paragraph;
import by.epamte.infohandler.entity.impl.Sentence;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser {

    public Paragraph parse(String stringText) {

        Pattern pattern = Pattern.compile(RegExps.sentenceRegEx);
        Paragraph paragraph = new Paragraph();
        SentenceParser sentenceParser = ParserFactory.sentenceParser();

        Matcher matcher = pattern.matcher(stringText);

        while (matcher.find()) {
            String sentenceString = matcher.group();

            Sentence sentence = sentenceParser.parse(sentenceString);
            paragraph.insertElement(sentence);
        }
        return paragraph;
    }

}
