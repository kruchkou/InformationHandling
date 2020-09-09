package by.epamte.infohandler.entity.impl;

import by.epamte.infohandler.entity.TextElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sentence implements TextElement {

    private final List<TextElement> sentence = new ArrayList<>();

    @Override
    public String value() {
        StringBuilder builder = new StringBuilder();

        for (TextElement element: sentence) {
            builder.append(element.value());
        }
        return builder.toString();
    }

    public List<TextElement> getElementList() {
        return sentence;
    }

    public void insertElement(TextElement TextElement) {
        sentence.add(TextElement);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sentence sentence1 = (Sentence) o;
        return Objects.equals(sentence, sentence1.sentence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sentence);
    }
}
