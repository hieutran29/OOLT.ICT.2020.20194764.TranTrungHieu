package hust.soict.globalict.aims.view;


public class Message {
    private static String error = "ERROR";
    private static String notification = "NOTIFICATION";
    private static String warning = "WARNING";
    private static String question = "QUESTION";
    private static String plain = "";

    public static int MESSAGE_ERROR = 1;
    public static int MESSAGE_NOTIFICATION = 2;
    public static int MESSAGE_WARNING = 3;
    public static int MESSAGE_QUESTION = 4;
    public static int MESSAGE_PLAIN = 5;

    private static String messageType(int type) {
        String messageType = "";
        if(type == MESSAGE_ERROR) {
            messageType = error;
        }
        else if(type == MESSAGE_NOTIFICATION) {
            messageType = notification;
        }
        else if(type == MESSAGE_WARNING) {
            messageType = warning;
        }
        else if(type == MESSAGE_QUESTION) {
            messageType = question;
        }
        else if(type == MESSAGE_PLAIN) {
            return plain;
        }
        return "<" + messageType + ">";
    }

    public static void printMessage(String message, int type) {
        String messageType = messageType(type);
        if(type == MESSAGE_PLAIN) {
            System.out.printf("%s", message);
        }
        else {
            System.out.printf("%s %s", messageType, message);
        }
    }
}
