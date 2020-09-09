package by.epamte.infohandler.util;

public class UtilFactory {

    private static final UtilFactory instance = new UtilFactory();

    private final SortBySizeUtil sortBySizeUtil = new SortBySizeUtil();
    private final SortByVowelPercentageUtil sortByVowelPercentageUtil = new SortByVowelPercentageUtil();
    private final TextToStringUtil getTextToStringUtil = new TextToStringUtil();

    private UtilFactory() {
    }

    public SortBySizeUtil getSortBySizeUtil() {
        return sortBySizeUtil;
    }

    public SortByVowelPercentageUtil getSortByVowelPercentageUtil() {
        return sortByVowelPercentageUtil;
    }

    public TextToStringUtil getGetTextToStringUtil() {
        return getTextToStringUtil;
    }

    public static UtilFactory getInstance() {
        return instance;
    }
}
