package src.View;

import src.Model.Borrow;
import src.Model.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;

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
    
    public void printBorrowsByJustification(String j){
        System.out.println(this.bc.toStringBorrowsByJustification(this.bc.getBorrows(), j));
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
        Borrow b = new Borrow(new Date(), new Date(), "Test", u);
        bc.addBorrow(b);
    }
}
