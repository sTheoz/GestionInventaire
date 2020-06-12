package src.View;

import src.Controller.BorrowsController;

public class BorrowView {
	
    public BorrowView(){
    }

    private void printBorrows(){
        System.out.println("Voici la liste de vos emprunts :");
    }
	
    public void printAllBorrows(){
        BorrowsController bc = BorrowsController.getInstance();
        System.out.println(bc.toStringBorrows(bc.getBorrows()));
    }

    public void printBorrowsByUser(int  id){
        BorrowsController bc = BorrowsController.getInstance();
        System.out.println(bc.toStringBorrowsByUser(bc.getBorrows(), id));
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
