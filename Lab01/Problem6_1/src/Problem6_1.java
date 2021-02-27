
import javax.swing.JOptionPane;

public class Problem6_1 {
    public static void main(String[] args) {
        int option = JOptionPane.showConfirmDialog(null, "Do you want to change first class ticket?");
        JOptionPane.showMessageDialog(null, "You have chosen: "
                                + (option == JOptionPane.YES_OPTION ? "YES" : "NO")); 
        System.exit(0);     
    }
}


/* Answer Question
 * Question 1: If we choose "Cancel", then the OptionPane shows "NO"
 * 
 * Question 2: To customize our Dialog, we can use function showOptionDialog()
 *              as demonstrated below:
 *  String optionChoice[] = {"I do", "I don't"};
 *  int option = JOptionPane.showOptionDialog(null, "choose: ", "title",
 *                                             JOptionPane.YES_NO_OPTION,
 *                                             JOptionPane.PLAINT_MESSAGE,
 *                                             null,
 *                                             optionChoice,
 *                                              0)


*/