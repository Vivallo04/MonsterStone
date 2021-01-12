package com.vivallo.monster.player;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/** Class Server manages the information
 * between host and guest.
 *
 * @version 1.0
 */

public class Server {

    private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private ServerSocket serverSocket;
    private Socket socket;
    private DataInputStream input;
    private int port;
    private String ip;


    /**
     * The Server constructor searchs for
     * an available port to use.
     * Range: 600 - 1000.
     *
     */


    public Server() {

        port = 6000;

        while (port < 10000) {
            try {
                serverSocket = new ServerSocket(port);
                logger.log(Level.INFO, "Sever initialized in port: " + getPort());
                break;

            } catch(IOException exception) {
                logger.log(Level.SEVERE, "Failed to initialize, try a new port");
                port++;

            }
        }
    }

    /**
     * Send the information when after
     * each turn.
     * @return message: UTF
     */

    public String finishTurn() {

        while (true) {

            try {
                logger.log(Level.INFO, "Waiting for a message...");
                socket = serverSocket.accept();
                logger.log(Level.INFO, "Message received successfully");

                input = new DataInputStream(socket.getInputStream());
                String message = input.readUTF();
                socket.close();

                return message;

            } catch (IOException exception) {
                logger.log(Level.SEVERE, "Message failed to receive");

            }
        }
    }


    /** Getters & setters -----------------
     * @return Host's ip address & server's
     * port respectively
     */

    public String getHost() {
        try {
            ip = InetAddress.getLocalHost().getHostAddress();

        } catch (UnknownHostException exception) {
            logger.log(Level.SEVERE, "Unknown Host");
        }

        return ip;

    }


    public int getPort() {
        return port;
    }


}
