package hust.soict.globalict.aims;

import javax.swing.JFrame;

import hust.soict.globalict.aims.data.CartDB;
import hust.soict.globalict.aims.data.StoreDB;
import hust.soict.globalict.aims.view.MainView;
import hust.soict.globalict.aims.view.viewstore.StoreScreen;

/**
 * @author HieuTran
 */


public class Aims {
	public static void main(String[] args) {
		new StoreDB();
		new CartDB();
//		new StoreScreen(storeDB.store);
		new MainView();
	}

}
