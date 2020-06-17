package src;

import src.View.*;

public class Start {
    public static void main(String[] args){
        MenuView menuView = new MenuView();
        while((menuView).executeMenu( (menuView).printMenu() ) != -1);
    }
	
}
