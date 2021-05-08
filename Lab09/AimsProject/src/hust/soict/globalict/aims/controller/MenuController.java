package hust.soict.globalict.aims.controller;

import hust.soict.globalict.aims.view.MainView;
import hust.soict.globalict.aims.view.Message;

public class MenuController extends Controller {
    private ViewStoreController viewStore = new ViewStoreController();
    private UpdateStoreController updateStore = new UpdateStoreController();
    private SeeCartController seeCart = new SeeCartController();

    @Override
    public void menu() {
        MainView.menu();
        
    }

    @Override
    public void start() {
        int choice;
        do {
            Message.printMessage("\n", Message.MESSAGE_PLAIN);
            menu();

            Message.printMessage("Enter choice: ", Message.MESSAGE_QUESTION);
            choice = scanner.nextInt();

            if(choice == 1) {
                storeDB.store.printMediasInStore();
                viewStore.start();
            }
            else if(choice == 2) {
                updateStore.start();
            }
            else if(choice == 3) {
                Message.printMessage("\n", Message.MESSAGE_PLAIN);
                cartDB.cart.displayCart();
                seeCart.start();
            }
            else if(choice == 0) {
                end();
                break;
            }
        } while(choice != 0);
    }

    private final void end() {
        scanner.close();
        Message.printMessage("Good bye!", Message.MESSAGE_NOTIFICATION);
    }

}
