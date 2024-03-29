package hust.soict.globalict.aims.controller;

import java.util.Scanner;

import hust.soict.globalict.aims.data.CartDB;
import hust.soict.globalict.aims.data.StoreDB;

public abstract class Controller {
    protected static Scanner scanner = new Scanner(System.in);
    protected static StoreDB storeDB = new StoreDB();
    protected static CartDB cartDB = new CartDB();

    public static void message(String msg) {
        System.out.println(msg);
    }

    public abstract void start();
    public abstract void menu();
}
