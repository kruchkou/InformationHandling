package by.epamte.infohandler.entity.impl;

import by.epamte.infohandler.entity.TextElement;

import java.util.Objects;

public class Word implements TextElement {

    private final String word;

    public Word(String word) {
        this.word = word;
    }

    @Override
    public String value() {
        return word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return word.equals(word1.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }
}
