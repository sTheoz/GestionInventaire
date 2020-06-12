package src;

import src.Controller.DevicesController;
import src.Controller.BorrowsController;
import src.Controller.StockController;
import src.View.DevicesView;
import src.View.BorrowView;
import src.View.StockView;

public class Start {
	
    public static void injectData(){
        System.out.println("================= DATA INJECTION =================");
        DevicesController devicesController = new DevicesController();
        BorrowsController borrowsController = new BorrowsController();
        StockController stockController = new StockController();
    }

    public static void main(String[] args){
        StockView stockView = new StockView();
        DevicesView devicesView = new DevicesView();
        BorrowView borrowView = new BorrowView();
        injectData();
    }
	
}
