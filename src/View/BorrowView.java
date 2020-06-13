package src.View;

import src.Controller.BorrowsController;

public class BorrowView {

    private BorrowsController bc;
	
    public BorrowView(){
        this.bc = BorrowsController.getInstance();
    }
	
    public void printAllBorrows(){
        System.out.println(this.bc.toStringBorrows(this.bc.getBorrows()));
    }

    public void printBorrowsByUser(int  id){
        System.out.println(this.bc.toStringBorrowsByUser(this.bc.getBorrows(), id));
    }

    public void printBorrowsInLate(){
        System.out.println(this.bc.toStringBorrowsInLate(this.bc.getBorrows()));
    }
    
    public void printBorrowsByJusitification(String j){
        System.out.println(this.bc.toStringBorrowsByJusitification(this.bc.getBorrows(), j));
    }
}
