package by.epamte.infohandler.entity.impl;

import by.epamte.infohandler.entity.TextElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Text implements TextElement {

    private List<TextElement> textList = new ArrayList<>();

    public List<TextElement> getElementList() {
        return textList;
    }

    @Override
    public String value() {
        StringBuilder builder = new StringBuilder();

        for (TextElement textElement : textList) {
            builder.append(textElement.value());
        }
        return builder.toString();

    }

    public void setElementList(List<TextElement> inputList) {
        textList = inputList;
    }

    public void insertElement(TextElement TextElement) {
        textList.add(TextElement);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Text text1 = (Text) o;
        return textList.equals(text1.textList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(textList);
    }
}
