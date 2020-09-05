package by.epamte.infohandler.parser;

import by.epamte.infohandler.entity.impl.Paragraph;
import by.epamte.infohandler.entity.impl.TextPart;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextBlockParser {

    public TextPart parse(String stringText) {

        ParagraphParser paragraphParser = ParserFactory.paragraphParser();
        TextPart textPart = new TextPart();

        Pattern pattern = Pattern.compile(RegExps.paragraphRegEx);
        Matcher matcher = pattern.matcher(stringText);

        while (matcher.find()) {
            String paragraphString = matcher.group();

            if (paragraphString != null) {
                Paragraph paragraph = paragraphParser.parse(paragraphString);

                textPart.insertElement(paragraph);
            }
        }
        return textPart;
    }
}
