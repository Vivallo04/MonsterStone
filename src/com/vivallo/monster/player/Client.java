package com.vivallo.monster.player;


import javax.swing.*;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * This class manages all
 * the client messages in order
 * to send the information to the
 * server.
 *
 * @version 1.0
 */

public class Client {

    private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private String HOST;
    private int port;


    /**
     * Constructor used by the guest.
     *  Request the IP port of the Host.
     */

    public Client() {

        while (true) {
            try {
                this.port = Integer.parseInt(JOptionPane.showInputDialog("Port: "));
                this.HOST = JOptionPane.showInputDialog("Host: ");
            } catch (NumberFormatException exception){

                logger.log(Level.SEVERE, "The port you entered is invalid");
                JOptionPane.showMessageDialog(null, "Please, enter a valid port");

            }
        }
    }


    /**
     * Constructor used by the host.
     * Host's and port's direction
     * received by the guest.
     *
     * @param host: Host's name
     * @param port: Client port
     */

    public Client(String host, int port) {
        host = host;
        port = Integer.parseInt(String.valueOf(port));
    }


    /** Send a message to the player
     * @param message: Message to send
     */

    public boolean sendMessage(String message) {
        DataOutputStream output;

        try {
            logger.info("Sending...");
            Socket socket = new Socket(HOST, port);

            output = new DataOutputStream(socket.getOutputStream());
            output.writeUTF(message);
            socket.close();

            logger.log(Level.INFO, "Your message's been sent");
            return false;

        } catch (IOException exception) {
            logger.log(Level.SEVERE, "Failed to send. Try sending again or enter a new port");
            return true;
        }
    }


    /** Getters & Setters
     * @return Host & port respectively
     *
     */

    public String getHOST() {
        return HOST;
    }

    public int getPort() {
        return port;
    }

}
