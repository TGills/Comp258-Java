
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class overrides some of the methods defined in the abstract superclass
 * in order to give more functionality to the client.
 *
 *
 */
public class ChatClient extends AbstractClient {
    //Instance variables **********************************************
    /**
     * The interface type variable. It allows the implementation of the display
     * method in the client.
     */
    ChatIF clientUI;
    TicTacTow game;
    //Constructors ****************************************************
    /**
     * Constructs an instance of the chat client.
     *
     * @param host The server to connect to.
     * @param port The port number to connect on.
     * @param clientUI The interface type variable.
     */
    public ChatClient(String host, int port, ChatIF clientUI)
            throws IOException {
        super(host, port); //Call the superclass constructor
        this.clientUI = clientUI;
        openConnection();
    }
    public ChatClient(String host, int port, String userName, ChatIF clientUI)
            throws IOException {
        super(host, port); //Call the superclass constructor
        this.clientUI = clientUI;
        openConnection();
        sendToServer("/join " + "Commons");
        sendToServer("/login " + userName);
    }
    //Instance methods ************************************************
    /**
     * This method handles all data that comes in from the server.
     *
     * @param msg The message from the server.
     */
    public void handleMessageFromServer(Object msg) {
        if (msg instanceof TicTacTow) {
            TicTacTow ttt = (TicTacTow) msg;
            ((GUIObjectConsole) clientUI).displayBoard(ttt);
            clientUI.display("Your move");
        } else {
            clientUI.display(msg.toString());
        }
    }
    /**
     * This method handles all data coming from the UI
     *
     * @param message The message from the UI.
     */
    public void handleMessageFromClientUI(String message) {
        if (message.charAt(0) == '/') {
            handleClientCommand(message);

        } else {
            try {
                //Differentiate between loacal and server commands
                sendToServer(message);
            } catch (IOException e) {
                clientUI.display("Could not send message to server.  Terminating client.");
                quit();
            }

        }

    }
    public void handleClientCommand(String message) {
        //ELSE IF's FOR EVERYTHING!!!! 

        if (message.startsWith("/getPort")) {
            clientUI.display(String.valueOf(getPort()));
        } else if (message.startsWith("/getHost")) {
            clientUI.display(String.valueOf(getHost()));
        } else if (message.startsWith("/logoff")) {
            try {
                closeConnection();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (message.startsWith("/login")) {
            try {
                openConnection();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (message.startsWith("/quit")) {
            clientUI.display("Dear Sir and or Madam, I am to inform you that "
                    + "I am about to quit. Have a good day.");
            quit();
        } else if (message.startsWith("/setHost")) {
            if (isConnected() == false) {
                setHost(message.split(" ")[1]);
            } else {
                clientUI.display("Client must be logged off");
            }
        } else if (message.startsWith("/setPort")) {
            if (isConnected() == false) {
                setPort(Integer.parseInt(message.split(" ")[1]));
            } else {
                clientUI.display("Client must be logged off");
            }
        } else {
            try {
                sendToServer(message);
            } catch (IOException e) {
                clientUI.display("Could not send message to server. Terminate");
                e.printStackTrace();
                quit();
            }
        }

    }
    /**
     * This method terminates the client.
     */
    public void quit() {
        try {
            closeConnection();
        } catch (IOException e) {
        }
        System.exit(0);
    }
    @Override
    protected void connectionException(Exception exception) {
        System.out.println("Server shutdown");
        connectionClosed();
    }
}
//End of ChatClient class
