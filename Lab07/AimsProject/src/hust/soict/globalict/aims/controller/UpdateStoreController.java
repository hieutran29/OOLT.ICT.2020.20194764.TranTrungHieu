package hust.soict.globalict.aims.controller;

import java.util.ArrayList;

import hust.soict.globalict.aims.model.book.Book;
import hust.soict.globalict.aims.model.disc.CD;
import hust.soict.globalict.aims.model.disc.DigitalVideoDisc;
import hust.soict.globalict.aims.model.disc.Track;
import hust.soict.globalict.aims.view.UpdateStoreMenu;

public class UpdateStoreController extends Controller {
    @Override
    public void menu() {
        UpdateStoreMenu.menu();
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
                String title = "", category = "";
				float cost = 0.0f;

				System.out.println("1. Add a book");
				System.out.println("2. Add a DVD");
                System.out.println("3. Add a CD");
				System.out.println("0. Exit");
				System.out.print("Choose: ");
				int choiceAdd = scanner.nextInt();
				scanner.nextLine();

				System.out.print("Title: "); title = scanner.nextLine();
				System.out.print("Category: "); category = scanner.nextLine();
				System.out.print("Cost: "); cost = scanner.nextFloat();
				scanner.nextLine();

				if(choiceAdd == 1) {
					String content = "";
					String authors = "";

					System.out.print("List of authors (separated by ','): ");	
					authors = scanner.nextLine();
					System.out.print("Content: ");	
                    content = scanner.nextLine();
                    
					storeDB.store.addMedia(new Book(title, category, content, authors.split("\\W+"), cost));
				}
				else if(choiceAdd == 2) {
					int length = 0;
					String director = "";

					System.out.print("Director: ");	    director = scanner.nextLine();
					System.out.print("Length: ");		length = scanner.nextInt();

					storeDB.store.addMedia(new DigitalVideoDisc(title, category, director, length, cost));
				}
                else if(choiceAdd == 3) {
                    String director = "";
                    String artist = "";
                    ArrayList<Track> tracks = new ArrayList<Track>();
                    String trackName = "";
                    int trackLength = 0;

                    System.out.print("Director: ");
                    director = scanner.nextLine();
                    System.out.print("Artist: ");
                    artist = scanner.nextLine();

                    char confirm_add_more_track;
                    do {
                        System.out.print("Track Name: ");
                        trackName = scanner.nextLine();
                        System.out.print("Track Length: ");
                        trackLength = Integer.parseInt(scanner.nextLine());

                        System.out.print("Do you want to add more track? (y/n): ");
                        confirm_add_more_track = scanner.next().charAt(0);

                        scanner.nextLine();

                        tracks.add(new Track(trackName, trackLength));
                    } while(confirm_add_more_track == 'y');

                    storeDB.store.addMedia(new CD(title, category, director, artist, tracks, cost));
                }
            }
            else if(choice == 2) {
				System.out.print("Input Removed ID: ");
				int ID = scanner.nextInt();
				storeDB.store.removeMedia(ID);
            }
            else if(choice == 0) {
                break;
            }
            else {
                message("ERROR: Choice invalid");
            }

        } while(choice >= 0 && choice <= UpdateStoreMenu.maxChoice());
    }
}
