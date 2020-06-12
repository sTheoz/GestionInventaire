package src.View;

import src.Controller.BorrowsController;

public class BorrowView {
	
    public BorrowView(){
        System.out.println("Voici la liste de vos emprunts :");
    }

    public void printAllBorrows(){
        BorrowsController bc = BorrowsController.getInstance();
        System.out.println(bc.toStringBorrows(bc.getBorrows()));
    }

    public void printBorrowsInLate(){
        BorrowsController bc = BorrowsController.getInstance();
        System.out.println(bc.toStringBorrowsInLate(bc.getBorrows()));
    }
    
    public void printBorrowsByJusitification(String j){
        BorrowsController bc = BorrowsController.getInstance();
        System.out.println(bc.toStringBorrowsByJusitification(bc.getBorrows(), j));
    }
}
