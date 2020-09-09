package by.epamte.infohandler.entity.impl;

import by.epamte.infohandler.entity.TextElement;

import java.util.Objects;

public class Digit implements TextElement {

    private final String digit;

    @Override
    public String value() {
        return digit;
    }

    public Digit(String value) {
        this.digit = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Digit digit1 = (Digit) o;
        return digit.equals(digit1.digit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(digit);
    }
}
