package src;

import src.Controller.*;
import src.View.*;

public class Start {
	
    public static void injectData(){
        System.out.println("================= DATA INJECTION =================");
        
    }

    public static void main(String[] args){
        DevicesController devicesController = new DevicesController();
        BorrowsController borrowsController = new BorrowsController();
        StockController stockController = new StockController();
        DevicesView devicesView = new DevicesView();
        BorrowView borrowView = new BorrowView();
        StockView stockView = new StockView();
        MenuView menuView = new MenuView();
        (menuView).printMenu();
        injectData();
    }
	
}
