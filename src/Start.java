package src;

import src.View.*;

/**
 * Start est le main du projet de Gestion d'emprunt
 * 
 * @author Lucas NAVETEUR et Théo SZATKOWSKI
 * @version 1.0
 */
public class Start {
    public static void main(String[] args){
        MenuView menuView = new MenuView();
        while((menuView).executeMenu( (menuView).printMenu() ) != -1);
    }
	
}
