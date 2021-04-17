package hust.soict.globalict.aims.controller;

import java.util.ArrayList;

import hust.soict.globalict.aims.model.book.Book;
import hust.soict.globalict.aims.model.disc.CD;
import hust.soict.globalict.aims.model.disc.DigitalVideoDisc;
import hust.soict.globalict.aims.model.disc.Track;
import hust.soict.globalict.aims.view.Message;
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
            Message.printMessage("\n", Message.MESSAGE_PLAIN);
            menu();

            Message.printMessage("Enter choice: ", Message.MESSAGE_QUESTION);
            choice = scanner.nextInt();

            if(choice == 1) {
                String title = "", category = "";
				float cost = 0.0f;

				Message.printMessage("1. Add a book\n", Message.MESSAGE_PLAIN);
				Message.printMessage("2. Add a DVD\n", Message.MESSAGE_PLAIN);
                Message.printMessage("3. Add a CD\n", Message.MESSAGE_PLAIN);
				Message.printMessage("0. Exit\n", Message.MESSAGE_PLAIN);
				Message.printMessage("Choose: ", Message.MESSAGE_PLAIN);
				int choiceAdd = scanner.nextInt();
				scanner.nextLine();

				Message.printMessage("Title: ", Message.MESSAGE_QUESTION); title = scanner.nextLine();
				Message.printMessage("Category: ", Message.MESSAGE_QUESTION); category = scanner.nextLine();
				Message.printMessage("Cost: ", Message.MESSAGE_QUESTION); cost = scanner.nextFloat();
				scanner.nextLine();

				if(choiceAdd == 1) {
					String content = "";
					String authors = "";

					Message.printMessage("List of authors (separated by ','): ", Message.MESSAGE_QUESTION);	
					authors = scanner.nextLine();
					Message.printMessage("Content: ", Message.MESSAGE_QUESTION);	
                    content = scanner.nextLine();
                    
					storeDB.store.addMedia(new Book(title, category, content, authors.split("\\W+"), cost));
				}
				else if(choiceAdd == 2) {
					int length = 0;
					String director = "";

					Message.printMessage("Director: ", Message.MESSAGE_QUESTION);
                    director = scanner.nextLine();
					Message.printMessage("Length: ", Message.MESSAGE_QUESTION);
                    length = scanner.nextInt();

					storeDB.store.addMedia(new DigitalVideoDisc(title, category, director, length, cost));
				}
                else if(choiceAdd == 3) {
                    String director = "";
                    String artist = "";
                    ArrayList<Track> tracks = new ArrayList<Track>();
                    String trackName = "";
                    int trackLength = 0;

                    Message.printMessage("Director: ", Message.MESSAGE_QUESTION);
                    director = scanner.nextLine();
                    Message.printMessage("Artist: ", Message.MESSAGE_QUESTION);
                    artist = scanner.nextLine();

                    char confirm_add_more_track;
                    do {
                        Message.printMessage("Track Name: ", Message.MESSAGE_QUESTION);
                        trackName = scanner.nextLine();
                        Message.printMessage("Track Length: ", Message.MESSAGE_QUESTION);
                        trackLength = Integer.parseInt(scanner.nextLine());

                        Message.printMessage("Do you want to add more track? (y/n): ", Message.MESSAGE_QUESTION);
                        confirm_add_more_track = scanner.next().charAt(0);

                        scanner.nextLine();

                        tracks.add(new Track(trackName, trackLength));
                    } while(confirm_add_more_track == 'y');

                    storeDB.store.addMedia(new CD(title, category, director, artist, tracks, cost));
                }
            }
            else if(choice == 2) {
				Message.printMessage("Input Removed ID: ", Message.MESSAGE_QUESTION);
				int ID = scanner.nextInt();
				storeDB.store.removeMedia(ID);
            }
        } while(choice != 0);
    }
}
