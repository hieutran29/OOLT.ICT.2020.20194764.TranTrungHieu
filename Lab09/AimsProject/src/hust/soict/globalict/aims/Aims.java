package hust.soict.globalict.aims;

import hust.soict.globalict.aims.controller.MenuController;
import hust.soict.globalict.aims.data.StoreDB;
import hust.soict.globalict.aims.view.viewstore.StoreScreen;

/**
 * @author HieuTran
 */


public class Aims {
	public static void main(String[] args) {
		StoreDB storeDB = new StoreDB();
		new StoreScreen(storeDB.store);
	}

}
