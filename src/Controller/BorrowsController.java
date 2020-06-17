package src.Controller;

import src.Model.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class BorrowsController implements Serializable{

    private ArrayList<Borrow> borrows;
    private static final long serialVersionUID = 15151515151515L;
    
    public BorrowsController(){
        borrows = new ArrayList<Borrow>();
    }
    
    public ArrayList<Borrow> getBorrows(){
        return borrows;
    }

    public String toStringBorrows(ArrayList<Borrow> borrows){
        String str = "";
        Iterator<Borrow> iter = borrows.iterator();
        while(iter.hasNext()){
            str += iter.next().toString()+"\n";
        }
        return str;
    }

    public String toStringBorrowsByUser(ArrayList<Borrow> borrows, int IDUser){
        String str = "";
        Iterator<Borrow> iter = borrows.iterator();
        Borrow b;
        while(iter.hasNext()){
            b = iter.next();
            if(b.getIDBorrower() == IDUser){
                str += b.toString()+"\n";
            }
        }
        return str;
    }

    public String toStringBorrowsByJustification(ArrayList<Borrow> borrows, String j){
        String str = "";
        Iterator<Borrow> iter = borrows.iterator();
        Borrow b;
        while(iter.hasNext()){
            b = iter.next();
            if(b.getJustification().compareTo(j) == 0){
                str += b.toString()+"\n";
            }
        }
        return str;
    }

    public String toStringBorrowsInLate(ArrayList<Borrow> borrows){
        String str = "";
        Iterator<Borrow> iter = borrows.iterator();
        Borrow b;
        Date d = new Date(System.currentTimeMillis());
        while(iter.hasNext()){
            b = iter.next();
            if(b.getEndBorrow().before(d)){
                str += b.toString()+"\n";
            }
        }
        return str;
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
