package hust.soict.globalict.aims.controller;

import hust.soict.globalict.aims.model.cart.Cart;
import hust.soict.globalict.aims.model.media.Media;
import hust.soict.globalict.aims.view.Message;
import hust.soict.globalict.aims.view.SeeCartMenu;

public class SeeCartController extends Controller {
    @Override
    public void menu() {
        SeeCartMenu.menu();
    }

    @Override
    public void start() {
        int choice;
        do {
            Message.printMessage("\n", Message.MESSAGE_PLAIN);
            menu();

            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            if(choice == 1) {
                Message.printMessage("Enter ID: ", Message.MESSAGE_QUESTION);
                int ID = scanner.nextInt();
                filterMediaByID(cartDB.cart, ID);
            }
            else if(choice == 2) {
                Message.printMessage("Enter Title: ", Message.MESSAGE_QUESTION);
                scanner.nextLine();
                String title = scanner.nextLine();
                filterMediaByTitle(cartDB.cart, title);
            }
            else if(choice == 3) {
                cartDB.cart.sortByCostDescending();
                cartDB.cart.printAllMedia();
            }
            else if(choice == 4) {
                cartDB.cart.sortByTitle();
                cartDB.cart.printAllMedia();
            }
            else if(choice == 5) {
				Message.printMessage("Input Removed ID: ", Message.MESSAGE_QUESTION);
				int ID = scanner.nextInt();
				cartDB.cart.removeMedia(ID);
            }
            else if(choice == 6) {
                Media luckyItem = cartDB.cart.getLuckyItem();

                if(luckyItem == null) {
                    Message.printMessage("Good luck next time\n", Message.MESSAGE_NOTIFICATION);
                }
                else {
                    Message.printMessage("Free: " + luckyItem.toString(), Message.MESSAGE_NOTIFICATION);
                }
            }
            else if(choice == 7) {
                cartDB.cart.clear();
                Message.printMessage("An order is created", Message.MESSAGE_NOTIFICATION);
            }

        } while(choice != 0);
    }

    private void filterMediaByID(Cart cart, int ID) {
        Media found = cart.searchByID(ID);
        Message.printMessage("\n----------\n", Message.MESSAGE_PLAIN);
        if(found != null) {
            Message.printMessage(found.toString(), Message.MESSAGE_PLAIN);
        }
        else {
            Message.printMessage("No media matching", Message.MESSAGE_ERROR);
        }
        Message.printMessage("\n----------\n", Message.MESSAGE_PLAIN);
    }
    
    private void filterMediaByTitle(Cart cart, String title) {
        Media[] found = cart.searchByTitle(title);
        if(found.length == 0) {
            Message.printMessage("No media matching", Message.MESSAGE_ERROR);
        }
        else {
            for(Media f : found) {
                Message.printMessage(f.toString(), Message.MESSAGE_PLAIN);
                Message.printMessage("\n", Message.MESSAGE_PLAIN);
            }
        }
    }
}
