package by.epamte.infohandler.parser;

import by.epamte.infohandler.dao.exception.DAOException;
import by.epamte.infohandler.entity.TextElement;
import by.epamte.infohandler.entity.impl.CodePart;
import by.epamte.infohandler.entity.impl.Text;
import by.epamte.infohandler.util.RegexPropertyUtil;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookParser {

    public Text createText(String stringText) throws DAOException {

        TextBlockParser textBlockParser = ParserFactory.textBlockParser();
        RegexPropertyUtil regexPropertyUtil = RegexPropertyUtil.getInstance();
        Pattern pattern = Pattern.compile(regexPropertyUtil.getProperty("partRegEx"));
        Text text = new Text();

        Matcher matcher = pattern.matcher(stringText);

        while (matcher.find()) {
            String textBlock = matcher.group("TextPart");
            String codeBLock = matcher.group("CodePart");

            if (textBlock != null) {
                List<TextElement> textPart = textBlockParser.parse(textBlock);

                for(TextElement sentences : textPart) {
                    text.insertElement(sentences);
                }
            }

            if (codeBLock != null) {
                codeBLock = codeBLock.trim();
                CodePart codePart = new CodePart(codeBLock+"\n");

                text.insertElement(codePart);
            }
        }
        return text;
    }

}
