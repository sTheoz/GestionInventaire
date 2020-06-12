package src;

import src.Controller.*;
import src.View.*;

public class Start {
	
    public static void injectData(){
        System.out.println("================= DATA INJECTION =================");
    }

    public static void main(String[] args){
        DevicesView devicesView = new DevicesView();
        BorrowView borrowView = new BorrowView();
        MenuView menuView = new MenuView();
        injectData();
        (menuView).executeMenu( (menuView).printMenu() );
    }
	
}
