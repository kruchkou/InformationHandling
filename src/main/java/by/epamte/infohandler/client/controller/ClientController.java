package by.epamte.infohandler.client.controller;

import by.epamte.infohandler.entity.impl.Text;
import by.epamte.infohandler.util.TextToStringUtil;
import by.epamte.infohandler.util.UtilFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.Socket;

public class ClientController {

    private static final Logger logger = LogManager.getLogger(ClientController.class);

    private Socket clientSocket;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    private final UtilFactory utilFactory = UtilFactory.getInstance();
    private final TextToStringUtil textToStringUtil = utilFactory.getGetTextToStringUtil();
    private final BufferedReader inputReader;

    public ClientController() {
        inputReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void start(Socket clientSocket) {
        try {

            objectInputStream = new ObjectInputStream(clientSocket.getInputStream());
            objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());

            System.out.println(getMessage());

            String response = readFromKeyboard();
            sendMessage(response);

            Thread.sleep(1000);

            Text text = getTextFromServer();

            System.out.println(textToStringUtil.process(text));

        }
        catch (IOException e) {
            logger.error("IOException at Client level", e);
            e.printStackTrace();
        }
        catch (InterruptedException e) {
            logger.error("InterruptedException at Client level", e);
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            logger.error("ClassNotFoundException at Client level", e);
            e.printStackTrace();
        }
        finally {
            try {
                clientSocket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getMessage() throws IOException {
        return objectInputStream.readUTF();
    }

    public void sendMessage(String message) throws IOException {
        objectOutputStream.writeUTF(message);
        objectOutputStream.flush();
    }

    public String readFromKeyboard() throws IOException {
        return inputReader.readLine();
    }

    public Text getTextFromServer() throws IOException, ClassNotFoundException {
        return (Text) objectInputStream.readObject();
    }
}
