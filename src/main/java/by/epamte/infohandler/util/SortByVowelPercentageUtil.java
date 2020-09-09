package by.epamte.infohandler.util;

import by.epamte.infohandler.entity.TextElement;
import by.epamte.infohandler.entity.impl.Text;
import by.epamte.infohandler.entity.impl.Word;
import by.epamte.infohandler.util.comparator.VowelPercentageComparator;

import java.util.List;

public class SortByVowelPercentageUtil {

    private final VowelPercentageComparator vowelPercentageComparator = new VowelPercentageComparator();
    private final TextElementExtractor textElementExtractor = TextElementExtractor.getInstance();

    public Text process(Text text) {

        Text resultText = new Text();
        List<TextElement> wordList = textElementExtractor.getWordListFromText(text);
        wordList.sort(vowelPercentageComparator);

        for (TextElement word: wordList) {
            resultText.insertElement(new Word(word.value()+"\n"));
        }
        return resultText;
    }

}
