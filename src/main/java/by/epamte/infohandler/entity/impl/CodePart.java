package by.epamte.infohandler.entity.impl;

import by.epamte.infohandler.entity.TextElement;

import java.util.Objects;

public class CodePart implements TextElement {

    private final String codePart;

    public CodePart(String codePart) {
        this.codePart = codePart;
    }

    @Override
    public String value() {
        return codePart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodePart codePart1 = (CodePart) o;
        return codePart.equals(codePart1.codePart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codePart);
    }
}
