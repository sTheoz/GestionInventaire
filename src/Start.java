package src;

import src.Controller.DevicesController;
import src.Controller.BorrowsController;
import src.Controller.StockController;
import src.View.DevicesView;
import src.View.BorrowView;
import src.View.StockView;

public class Start {
    DevicesController devicesController = new DevicesController();
    BorrowsController borrowsController = BorrowsController.getInstance();
    StockController stockController = new StockController();
    StockView stockView = new StockView();
    DevicesView devicesView = new DevicesView();
    BorrowView borrowView = new BorrowView();
	
    public static void injectData(){
        System.out.println("================= DATA INJECTION =================");
    }

    public static void main(String[] args){
        injectData();
    }
	
}
