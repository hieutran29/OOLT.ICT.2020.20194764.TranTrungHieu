package hust.soict.globalict.aims.view;

import javax.swing.JOptionPane;

public class Message {

    public static int MESSAGE_PLAIN = -1;
    public static int MESSAGE_ERROR = 0;
    public static int MESSAGE_INFORMATION = 1;
    public static int MESSAGE_WARNING = 2;
    public static int MESSAGE_QUESTION = 3;

    private static String messageType(int type) {
        String messageType = "";
        if(type == MESSAGE_ERROR) {
            messageType = "ERROR";
        }
        else if(type == MESSAGE_INFORMATION) {
            messageType = "INFORMATION";
        }
        else if(type == MESSAGE_WARNING) {
            messageType = "WARNING";
        }
        else if(type == MESSAGE_QUESTION) {
            messageType = "QUESTION";
        }
        else if(type == MESSAGE_PLAIN) {
            return "PLAIN";
        }
        return "<" + messageType + ">";
    }

    public static void displayMessage(String message, int type) {
        JOptionPane.showMessageDialog(null, message, null, type);
    }
}
