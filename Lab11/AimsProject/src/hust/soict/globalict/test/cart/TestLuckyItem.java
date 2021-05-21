package hust.soict.globalict.test.cart;

import javax.naming.LimitExceededException;

import hust.soict.globalict.aims.model.book.Book;
import hust.soict.globalict.aims.model.cart.Cart;
import hust.soict.globalict.aims.model.disc.DigitalVideoDisc;
import hust.soict.globalict.aims.model.media.Media;

public class TestLuckyItem {
    public static void main(String[] args) throws LimitExceededException {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 90, 24f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 100, 24f);

        Book book = new Book("Tam Quoc Dien Nghia", "Lich Su", "Blah, Blah,,,, Blah", 
                            new String[] {"Tran Trung Hieu", "La Quan Trung"}, 10f);

        cart.addMedia(dvd1, dvd2, dvd3, dvd4, dvd5, book);

        Media luckyItem = cart.getLuckyItem();
        if(luckyItem == null) {
            System.out.println("Good Luck Next Time :(");
        }
        else {
            System.out.println("Lucky Item:");
            System.out.println(luckyItem.toString());
            System.out.println();
        }
        cart.displayCart();
    }
}
