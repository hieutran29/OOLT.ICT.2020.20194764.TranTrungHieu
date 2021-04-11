package hust.soict.globalict.aims.controller;

import hust.soict.globalict.aims.model.cart.Cart;
import hust.soict.globalict.aims.model.media.Media;
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
            System.out.println();
            menu();

            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            if(choice == 1) {
                System.out.println("1. Filter by ID");
				System.out.println("2. Filter by Title");
				System.out.print("Choose: ");
				int filterChoice = scanner.nextInt();
				
                if(filterChoice == 1) {
                    System.out.print("Enter ID: ");
                    int ID = scanner.nextInt();
					filterMediaByID(cartDB.cart, ID);
                }
                else if(filterChoice == 2) {
                    System.out.print("Enter Title: ");
                    scanner.nextLine();
                    String title = scanner.nextLine();
					filterMediaByTitle(cartDB.cart, title);
                }
            }
            else if(choice == 2) {
				System.out.println("1. Sort by cost");
				System.out.println("2. Sort by title");
				System.out.print("Choose: ");
				int sortType = scanner.nextInt();
				
				if(sortType == 1) {
					cartDB.cart.sortByCostDescending();
					cartDB.cart.printAllMedia();
				}
				else if(sortType == 2) {
					cartDB.cart.sortByTitle();
					cartDB.cart.printAllMedia();
				}
            }
            else if(choice == 3) {
				System.out.print("Input Removed ID: ");
				int ID = scanner.nextInt();
				cartDB.cart.removeMedia(ID);
            }
            else if(choice == 4) {
                Media luckyItem = cartDB.cart.getLuckyItem();

                if(luckyItem == null) {
                    message("GOOD LUCK NEXT TIME :(");
                }
                else {
                    message(luckyItem.getDetail());
                }
            }
            else if(choice == 5) {
                cartDB.cart.clear();
                System.out.println("An order is created");
            }
            else if(choice == 0) {
                return;
            }
            else {
                message("ERROR: Choice invalid");
            }

        } while(choice >= 0 && choice <= SeeCartMenu.maxChoice());
    }

    private void filterMediaByID(Cart cart, int ID) {
        Media found = cart.searchByID(ID);
        System.out.println("\n----------");
        if(found != null) {
            System.out.println(found.getDetail());
        }
        else {
            System.out.println("NO Media MATCHING");
        }
        System.out.println("----------\n");
    }
    
    private void filterMediaByTitle(Cart cart, String title) {
        Media[] found = cart.searchByTitle(title);
        if(found.length == 0) {
            System.out.println("NO Media MATCHING");
        }
        else {
            for(Media f : found) {
                System.out.println(f.getDetail());
                System.out.println();
            }
        }
    }
}
