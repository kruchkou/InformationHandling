package by.epamte.infohandler.parser;

public class ParserFactory {

    private static BookParser bookParser;
    private static TextBlockParser textBlockParser;
    private static ParagraphParser paragraphParser;
    private static SentenceParser sentenceParser;

    public ParserFactory() {}

    public static BookParser bookParser()  {
        if (bookParser == null) {
            bookParser = new BookParser();
        }
        return bookParser;
    }

    public static TextBlockParser textBlockParser() {
        if (textBlockParser == null) {
            textBlockParser = new TextBlockParser();
        }
        return textBlockParser;
    }

    public static ParagraphParser paragraphParser() {
        if (paragraphParser == null) {
            paragraphParser = new ParagraphParser();
        }
        return paragraphParser;
    }

    public static SentenceParser sentenceParser() {
        if (sentenceParser == null) {
            sentenceParser = new SentenceParser();
        }
        return sentenceParser;
    }

}
