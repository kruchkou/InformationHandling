package by.epamte.infohandler.entity.impl;

import by.epamte.infohandler.entity.ITextElement;

import java.util.Objects;

public class PunctMark implements ITextElement {

    private final String punctMark;

    public PunctMark(String punctMark) {
        this.punctMark = punctMark;
    }

    public String value() {
        return punctMark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PunctMark punctMark1 = (PunctMark) o;
        return punctMark.equals(punctMark1.punctMark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(punctMark);
    }
}
