package by.epamte.infohandler.util;

import by.epamte.infohandler.entity.TextElement;
import by.epamte.infohandler.entity.impl.*;
import by.epamte.infohandler.service.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;

public class TextElementExtractor {

    private static final TextElementExtractor instance = new TextElementExtractor();

    private TextElementExtractor() {
    }

    public static TextElementExtractor getInstance() {
        return instance;
    }

    public List<TextElement> getSentenceList(Text text) {

        List<TextElement> resultList = text.getElementList();

        resultList = extractElemListByClassName(resultList, Sentence.class);

        return resultList;
    }

    public List<TextElement> getWordListFromSentence(TextElement inputSentence) {
        if (inputSentence == null || inputSentence.getClass() != Sentence.class) {
            throw new ServiceException("Incorrect input type in Extractor!");
        }

        Sentence sentence = (Sentence) inputSentence;

        List<TextElement> resultList = sentence.getElementList();

        resultList = extractElemListByClassName(resultList, Word.class);

        return resultList;
    }

    public List<TextElement> getWordListFromText(Text text) {
        List<TextElement> resultList = new ArrayList<>();
        List<TextElement> sentenceList = text.getElementList();

        sentenceList = extractElemListByClassName(sentenceList, Sentence.class);

        for (TextElement sentence : sentenceList) {
            List<TextElement> wordList = getWordListFromSentence(sentence);

            resultList.addAll(wordList);
        }
        return resultList;
    }


    private List<TextElement> extractElemListByClassName(List<TextElement> elementList, Class extractClass) {
        List<TextElement> resultList = new ArrayList<>();

        for (TextElement element : elementList) {
            if (element != null && element.getClass() == extractClass) {
                resultList.add(element);
            }
        }
        return resultList;
    }

}
