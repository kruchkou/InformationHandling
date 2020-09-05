package by.epamte.infohandler.parser;

import by.epamte.infohandler.entity.impl.CodePart;
import by.epamte.infohandler.entity.impl.Text;
import by.epamte.infohandler.entity.impl.TextPart;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookParser {

    public Text createText(String stringText) {

        TextBlockParser textBlockParser = ParserFactory.textBlockParser();

        Pattern pattern = Pattern.compile(RegExps.partRegEx);
        Text text = new Text();

        Matcher matcher = pattern.matcher(stringText);

        while (matcher.find()) {
            String textBlock = matcher.group("TextPart");
            String codeBLock = matcher.group("CodePart");

            if (textBlock != null) {
                TextPart textPart = textBlockParser.parse(textBlock);

                text.insertElement(textPart);
            }

            if (codeBLock != null) {
                CodePart codePart = new CodePart(codeBLock);

                text.insertElement(codePart);
            }
        }

        return text;
    }

}
