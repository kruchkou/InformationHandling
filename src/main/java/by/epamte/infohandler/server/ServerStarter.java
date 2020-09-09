package by.epamte.infohandler.server;

import by.epamte.infohandler.server.controller.ServerController;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerStarter {

    private static final Logger logger = LogManager.getLogger(ServerStarter.class);
    private static final int PORT = 2727;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        Socket clientSocket;

        try {
            serverSocket = new ServerSocket(PORT);
            clientSocket = serverSocket.accept();

            ServerController serverController = new ServerController();
            serverController.start(clientSocket);

            clientSocket.close();


        } catch (IOException e) {
            logger.error("IOException at level ServerStarter", e);
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                logger.error("IOException at level ServerStarter", e);
            }
        }

    }
}
