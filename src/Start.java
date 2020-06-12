package src;

import src.View.DevicesView;
import src.View.BorrowView;
import src.View.StockView;

public class Start {
	
    public static void main(String[] args){
        System.out.println("ok");
        DevicesView devicesView = new DevicesView();
        StockView stockView = new StockView();
        BorrowView borrowView = new BorrowView();
    }
	
}
