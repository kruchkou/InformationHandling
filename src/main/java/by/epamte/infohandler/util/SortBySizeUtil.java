package by.epamte.infohandler.util;

import by.epamte.infohandler.entity.TextElement;
import by.epamte.infohandler.entity.impl.Text;
import by.epamte.infohandler.util.comparator.WordCountComparator;

import java.util.List;

public class SortBySizeUtil {

    private final WordCountComparator wordCountComparator = new WordCountComparator();
    private final TextElementExtractor textElementExtractor = TextElementExtractor.getInstance();

    public Text process(Text text) {

        Text result = new Text();

        List<TextElement> sentenceList = textElementExtractor.getSentenceList(text);

        sentenceList.sort(wordCountComparator);
        result.setElementList(sentenceList);

        return result;
    }

}
