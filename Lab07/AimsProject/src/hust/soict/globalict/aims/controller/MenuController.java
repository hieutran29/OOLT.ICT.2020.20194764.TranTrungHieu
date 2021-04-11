package hust.soict.globalict.aims.controller;

import hust.soict.globalict.aims.view.MainMenu;

public class MenuController extends Controller {
    private ViewStoreController viewStore = new ViewStoreController();
    private UpdateStoreController updateStore = new UpdateStoreController();
    private SeeCartController seeCart = new SeeCartController();

    @Override
    public void menu() {
        MainMenu.menu();
        
    }

    @Override
    public void start() {
        int choice;
        do {
            System.out.println();
            menu();

            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            if(choice == 1) {
                storeDB.store.printMediasInStore();
                viewStore.start();
            }
            else if(choice == 2) {
                updateStore.start();
            }
            else if(choice == 3) {
                System.out.println();
                cartDB.cart.displayCart();
                seeCart.start();
            }
            else if(choice == 0) {
                end();
                break;
            }
            else {
                message("ERROR: Choice invalid");
            }

        } while(choice != 0);
    }

    private final void end() {
        scanner.close();
        System.out.println("Good bye!");
    }

}
