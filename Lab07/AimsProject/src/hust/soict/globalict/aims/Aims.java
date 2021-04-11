package hust.soict.globalict.aims;

import hust.soict.globalict.aims.controller.MenuController;

/**
 * @author HieuTran
 */


public class Aims {
	public static void main(String[] args) {
		MemoryDaemon memoryDaemon = new MemoryDaemon();
		Thread thread = new Thread(memoryDaemon);
		thread.start();
		MenuController menuController = new MenuController();
		menuController.start();
	}

}
