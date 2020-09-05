package by.epamte.infohandler.entity.impl;

import by.epamte.infohandler.entity.ITextElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sentence implements ITextElement {

    private List<ITextElement> sentence = new ArrayList<>();

    @Override
    public String value() {
        StringBuilder builder = new StringBuilder();

        for (ITextElement element: sentence) {
            builder.append(element.value());
        }
        return builder.toString();
    }

    public void insertElement(ITextElement ITextElement) {
        sentence.add(ITextElement);
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
