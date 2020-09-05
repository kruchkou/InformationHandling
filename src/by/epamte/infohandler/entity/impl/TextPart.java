package by.epamte.infohandler.entity.impl;

import by.epamte.infohandler.entity.ITextElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TextPart implements ITextElement {

    private List<ITextElement> textPart = new ArrayList<>();

    @Override
    public String value() {
        StringBuilder builder = new StringBuilder();

        for (ITextElement element : textPart) {
            builder.append(element.value());
            builder.append("\n");
        }
        return builder.toString();
    }

    public void insertElement(ITextElement ITextElement) {
        textPart.add(ITextElement);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextPart textPart1 = (TextPart) o;
        return Objects.equals(textPart, textPart1.textPart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(textPart);
    }
}
