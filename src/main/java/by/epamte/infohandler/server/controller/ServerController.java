package by.epamte.infohandler.server.controller;

import by.epamte.infohandler.server.MessageGenerator;
import by.epamte.infohandler.service.ServiceFactory;
import by.epamte.infohandler.service.TextService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerController {

    private static final Logger logger = LogManager.getLogger(ServerController.class);

    private ObjectInputStream requestStream;
    private ObjectOutputStream responseStream;
    private final ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private final TextService textService = serviceFactory.getTextService();
    private final MessageGenerator messageGenerator = MessageGenerator.getInstance();


    public void start(Socket clientSocket) {

        try {
            responseStream = new ObjectOutputStream(clientSocket.getOutputStream());
            requestStream = new ObjectInputStream(clientSocket.getInputStream());

            sendMessage(messageGenerator.welcomeMessage());

            Thread.sleep(1000);

            String response = readResponse();
            System.out.printf("Client choice mode %s. Proceed...",response);
            doTask(response);

        }
        catch (IOException e) {
            logger.error("IOException at Server level", e);
            e.printStackTrace();
        }
        catch (InterruptedException e) {
            logger.error("InterruptedException at Server level", e);
            e.printStackTrace();
        }
        finally {

        }

    }

    public void sendMessage(String message) throws IOException {
        responseStream.writeUTF(message);
        responseStream.flush();
    }

    private String readResponse() throws IOException {
        return requestStream.readUTF();
    }

    public void doTask(String clientRequest) throws IOException {
        switch (clientRequest) {
            case "1": {
                responseStream.writeObject(textService.text());
                responseStream.flush();
                break;
            }
            case "2": {
                responseStream.writeObject(textService.getSortedBySizeText(textService.text()));
                responseStream.flush();
                break;
            }
            case "3": {
                responseStream.writeObject(textService.getSortedByVowelPercentageWordsList(textService.text()));
                responseStream.flush();
                break;
            }
        }
    }
}
