package by.epamte.infohandler.util;

import by.epamte.infohandler.entity.TextElement;
import by.epamte.infohandler.entity.impl.Text;

public class TextToStringUtil {

    public String process(Text text) {
        StringBuilder builder = new StringBuilder();

        for (TextElement textElement : text.getElementList()) {
            builder.append(textElement.value());
        }
        return builder.toString();

    }
}
