package by.epamte.infohandler.entity.impl;

import by.epamte.infohandler.entity.ITextElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Text {

    private List<ITextElement> text = new ArrayList<>();

    public String value() {

        StringBuilder builder = new StringBuilder();

        for (ITextElement ITextElement : text) {
            builder.append(ITextElement.value());
        }

        return builder.toString();
    }

    public void insertElement(ITextElement ITextElement) {
        text.add(ITextElement);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Text text1 = (Text) o;
        return text.equals(text1.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }
}
