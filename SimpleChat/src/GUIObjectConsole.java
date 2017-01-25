
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.IOException;

/*
 * @author guillaume2127
 */
public class GUIObjectConsole extends JFrame implements ChatIF {

    final public static int DEFAULT_PORT = 5555;
    ChatClient client;
    private String host;
    private int port;
    private String user;

    private JButton closeB = new JButton("Close");
    private JButton openB = new JButton("Open");
    private JButton sendB = new JButton("Send");
    private JButton quitB = new JButton("Quit");

    private JTextField portTxF = new JTextField("5555");
    private JTextField hostTxF = new JTextField("127.0.0.1");
    private JTextField messageTxF = new JTextField("");
    private JTextField userNameTxF = new JTextField("");

    private JLabel portLB = new JLabel("Port: ", JLabel.RIGHT);
    private JLabel hostLB = new JLabel("Host: ", JLabel.RIGHT);
    private JLabel messageLB = new JLabel("Message: ", JLabel.RIGHT);
    private JLabel userNameLB = new JLabel("User name: ", JLabel.RIGHT);

    private JTextArea messageList = new JTextArea();

    public GUIObjectConsole(String host, int port, String user) {

        super("Simple Chat GUI");
        setSize(300, 400);

        setLayout(new BorderLayout(5, 5));
        Panel bottom = new Panel();
        add("Center", messageList);
        add("South", bottom);

        bottom.setLayout(new GridLayout(6, 2, 5, 5));
        bottom.add(hostLB);
        bottom.add(hostTxF);
        bottom.add(portLB);
        bottom.add(portTxF);
        bottom.add(messageLB);
        bottom.add(messageTxF);
        bottom.add(userNameLB);
        bottom.add(userNameTxF);
        bottom.add(openB);
        bottom.add(sendB);
        bottom.add(closeB);
        bottom.add(quitB);

        setVisible(true);

        //Send
        sendB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                send(messageTxF.getText() + "\n");
                //display(messageTxF.getText() + "\n");
            }
        });
        //Send
        closeB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                send("/logoff");
                //display(messageTxF.getText() + "\n");
            }
        });
        //Quit
        quitB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                send("/quit");
                //display(messageTxF.getText() + "\n");
            }
        });
        //Open
        openB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                open();
                //display(messageTxF.getText() + "\n");
            }
        });

        this.host = host;
        this.port = port;
        this.user = user;

    }

    public void send(String msg) {
        client.handleMessageFromClientUI(msg);
    }

    public void display(String message) {
        messageList.insert(message + "/n", 0);

    }

    public void open() {
        user = userNameTxF.getText();
        try {
            client = new ChatClient(host, port, user, this);
        } catch (Exception exception) {
            System.out.println("Error: Can't setup connection!"
                    + " Terminating client.");
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        String host = "";
        String user = "Someone";
        int port = 0;  //The port number

        try {
            host = args[0];
            System.out.println(host);
        } catch (ArrayIndexOutOfBoundsException e) {
            host = "localhost";
        }
        try {
            port = Integer.parseInt(args[1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            port = DEFAULT_PORT;
        }
        try {
            user = args[2];
        } catch (ArrayIndexOutOfBoundsException e) {
            user = "anon";
        }

        GUIObjectConsole chat = new GUIObjectConsole(host, port, user);

        //chat.accept();  //Wait for console data
    }
}
