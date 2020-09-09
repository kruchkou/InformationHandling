package by.epamte.infohandler.util.comparator;

import by.epamte.infohandler.entity.TextElement;
import by.epamte.infohandler.entity.impl.Word;
import by.epamte.infohandler.service.exception.ServiceException;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VowelPercentageComparator implements Comparator<TextElement> {

    @Override
    public int compare(TextElement word1, TextElement word2) {

        if (word1 == null || word1.getClass() != Word.class) {
            if (word2 == null || word2.getClass() != Word.class) {
                throw new ServiceException("Incorrect type into VowelPercentageComparator");
            }
        }

        String stringWord1 = word1.value();
        String stringWord2 = word2.value();


        if (getVowelPercentage(stringWord1) > getVowelPercentage(stringWord2)) {
            return 1;
        } else if (getVowelPercentage(stringWord1) < getVowelPercentage(stringWord2)) {
            return -1;
        } else {
            return stringWord1.compareTo(stringWord2);
        }

    }

    public double getVowelPercentage(String word) {
        final String vowelRegEx = "([aAeEiIoOuUyY])";

        Pattern pattern = Pattern.compile(vowelRegEx);
        Matcher matcher = pattern.matcher(word);

        double foundQuantity = 0;

        while (matcher.find()) {
            foundQuantity++;
        }

        return foundQuantity / word.length();
    }

}
