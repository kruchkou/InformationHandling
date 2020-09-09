package by.epamte.infohandler.server;

public class MessageGenerator {

    private static MessageGenerator instance = new MessageGenerator();

    private MessageGenerator() {
    }

    public static MessageGenerator getInstance() {
        return instance;
    }

    public String welcomeMessage() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hello, User!\n");
        stringBuilder.append("1) Get text\n");
        stringBuilder.append("2) Get text with sentences sorted by size\n");
        stringBuilder.append("3) Get words list sorted by vowel percentage\n");

        return stringBuilder.toString();
    }

}
