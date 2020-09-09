package by.epamte.infohandler.util.comparator;

import by.epamte.infohandler.entity.TextElement;
import by.epamte.infohandler.util.TextElementExtractor;

import java.util.Comparator;
import java.util.List;

public class WordCountComparator implements Comparator<TextElement> {

    private final TextElementExtractor textElementExtractor = TextElementExtractor.getInstance();

    @Override
    public int compare(TextElement sentence1, TextElement sentence2) {

        List<TextElement> wordList1 = textElementExtractor.getWordListFromSentence(sentence1);
        List<TextElement> wordList2 = textElementExtractor.getWordListFromSentence(sentence2);

        return wordList1.size() - wordList2.size();

    }
}
