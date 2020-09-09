package by.epamte.infohandler.client;

import by.epamte.infohandler.client.controller.ClientController;
import by.epamte.infohandler.server.controller.ServerController;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.Socket;

public class ClientStarter {

    private static final Logger logger = LogManager.getLogger(ClientStarter.class);
    private final static String HOST = "localhost";
    private final static int PORT = 2727;

    public static void main(String[] args) {
        ClientController clientController = new ClientController();
        Socket clientSocket = null;

        try {

            clientSocket = new Socket(HOST, PORT);
            clientController.start(clientSocket);

        } catch (IOException e) {
            logger.error("IOException at level ClientStarter", e);
            e.printStackTrace();

        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                logger.error("IOException at level ClientStarter", e);
                e.printStackTrace();
            }
        }

    }

}
