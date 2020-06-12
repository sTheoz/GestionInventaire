package src.Controller;

import src.Model.*;
import java.util.ArrayList;

public class BorrowsController {

    private ArrayList<Borrow> borrows;
	
    private BorrowsController(){
        borrows = new ArrayList<Borrow>();
    }
    
    public ArrayList<Borrow> getBorrows(){
        return borrows;
    }

     /** Instance unique non préinitialisée */
     private static BorrowsController INSTANCE = null;
     
     /** Point d'accès pour l'instance unique du Stock */
    public static BorrowsController getInstance(){           
        if (INSTANCE == null){ 
            INSTANCE = new BorrowsController(); 
        }
        return INSTANCE;
    }
    
    public void addBorrow(Borrow b){
        borrows.add(b);
    }

    public void removeBorrow(Borrow b){
        borrows.remove(b);
    }
}
