package src.View;

import java.util.Scanner;

public class MenuView {
    Scanner in = new Scanner(System.in); // OR replace System.in with file to read
    int term_result = 0;
    
    public MenuView(){
    }

    public void printMenu(){
        while((this.in).hasNext()){
            System.out.println("Voici le menu :");
            System.out.println("1 : Oui");
            System.out.println("2 : Oui");
            System.out.println("3 : Oui");
            System.out.println("4 : Oui");
            this.term_result = (this.in).nextInt();
        }
    }
	
}
