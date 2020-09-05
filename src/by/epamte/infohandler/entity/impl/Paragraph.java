package by.epamte.infohandler.entity.impl;

import by.epamte.infohandler.entity.ITextElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Paragraph implements ITextElement {

    private List<ITextElement> paragraph = new ArrayList<>();

    @Override
    public String value() {
        StringBuilder builder = new StringBuilder();

        for (ITextElement element : paragraph) {
            builder.append(element.value());
        }
        return builder.toString();
    }

    public void insertElement(ITextElement ITextElement) {
        paragraph.add(ITextElement);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paragraph paragraph1 = (Paragraph) o;
        return Objects.equals(paragraph, paragraph1.paragraph);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paragraph);
    }
}
