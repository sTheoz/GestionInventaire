package src.Controller;

import src.Model.Borrow;
import java.util.ArrayList;

public class BorrowsController {

    private ArrayList<Borrow> borrows;
	
    public BorrowsController(){
    }
    
    public ArrayList<Borrow> getBorrows(){
        return borrows;
    }

}
