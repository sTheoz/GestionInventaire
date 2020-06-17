package src.View;

import src.Model.Borrow;
import src.Model.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import src.Controller.BorrowsController;

public class BorrowView {

    private BorrowsController bc;
	
    public BorrowView(){
        this.bc = BorrowsController.getInstance();
    }
	
    public void printAllBorrows(){
        System.out.println(this.bc.toStringBorrows(this.bc.getBorrows()));
    }

    public int printBorrowsByUser(int  id){
        String str = this.bc.toStringBorrowsByUser(this.bc.getBorrows(), id);
        System.out.println(str);
        if(str == "")return 0;
        return 1;
    }

    public void printBorrowsInLate(){
        System.out.println(this.bc.toStringBorrowsInLate(this.bc.getBorrows()));
    }
    
    public int printBorrowsByJustification(String j){
        String str = this.bc.toStringBorrowsByJustification(this.bc.getBorrows(), j);
        System.out.println(str);
        if(str == "")return 0;
        return 1;
    }

    public void serialise(){
        ArrayList<Borrow> l = bc.getBorrows();
        for(Borrow b : l){
            b.serialise();
        }
    }

    public void deserialise(){
        try{
            File fichier =  new File("data/borrowController1.ser") ;

            // ouverture d'un flux sur un fichier
            ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(fichier)) ;
                    
            // désérialization de l'objet
            bc.addBorrow((Borrow) ois.readObject());
            System.out.println(bc.toStringBorrows(bc.getBorrows())) ;
        }catch(IOException|ClassNotFoundException e){
            System.err.println("Errorrrr");
        }  
    }

    public void addBorrow(){
        User u = new User("Jean", "Paul", "addr", "0600505", "test@gmail.com", 2);
        Borrow b = new Borrow(new GregorianCalendar(), new GregorianCalendar(), "Test", u);
        bc.addBorrow(b);
    }

    public void addBorrow(GregorianCalendar expiration, String justif, User u){
        //User u = new User("Jean", "Paul", "addr", "0600505", "test@gmail.com", 2);
        Borrow b = new Borrow(new GregorianCalendar(), expiration, justif, u);
        bc.addBorrow(b);
    }
}
