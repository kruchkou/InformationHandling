package by.epamte.infohandler.parser;

public class RegExps {

    public static String partRegEx = "(?<TextPart>[^{}]+\\n)|(?<CodePart>.*\\{(.*\\n)+?(\\n*})+)";
    public static String paragraphRegEx = "(.*?)\\n";
    public static String sentenceRegEx = "([^\\.]+.)";
    public static String partOfSentenceRegEx = "(\\d+)|([A-Za-zА-Яа-я]+)|(\\W+)";
    public static String wordRegEx = "[A-Za-zА-Яа-я]+";
    public static String digitRegEx  = "\\d+";

}
