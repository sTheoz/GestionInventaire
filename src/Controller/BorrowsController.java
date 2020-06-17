package src.Controller;

import src.Model.*;
import src.Model.devices.Device;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Scanner;

public class BorrowsController implements Serializable{

    private ArrayList<Borrow> borrows;
    private static final long serialVersionUID = 15151515151515L;
    private int id;
    
    public BorrowsController(){
        borrows = new ArrayList<Borrow>();
        this.id = 0;
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
        /*Iterator<Borrow> iter = borrows.iterator();
        Borrow b;
        Date d = new Date(System.currentTimeMillis());
        while(iter.hasNext()){
            b = iter.next();
            if(b.getEndBorrow() ){
                str += b.toString()+"\n";
            }
        }*/
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

    public int getId(){
        int idR = this.id;
        this.id++;
        return idR;
    }

    public void modifyExpiration(int id, Scanner input){
        Iterator<Borrow> iter = borrows.iterator();
        Borrow b;
        while(iter.hasNext()){
            b = iter.next();
            if(b.getID() == id){
                System.out.print("Année d'expiration :");
                String year = input.nextLine();
                System.out.print("Jour d'expiration :");
                String day = input.nextLine();
                System.out.print("Mois d'expiration :");
                String month = input.nextLine();
                GregorianCalendar c = new GregorianCalendar(Integer.parseInt(year), Integer.parseInt(month)-1, Integer.parseInt(day));
                b.setEndBorrow(c);
                return;
            }
        }
    }

    public void modifyJustification(int id, Scanner input){
        Iterator<Borrow> iter = borrows.iterator();
        Borrow b;
        while(iter.hasNext()){
            b = iter.next();
            if(b.getID() == id){
                System.out.print("Mettez la nouvelle justification :");
                String j = input.nextLine();
                b.setJustification(j);
                return;
            }
        }
    }

    public void addDevice(Borrow b, Device d){
        b.addDevice(d);
    }

    public void deleteDevice(Borrow b , Device d){
        b.removeDevice(d);
    }

    public void closeBorrow(int id){
        Iterator<Borrow> iter = borrows.iterator();
        Borrow b;
        while(iter.hasNext()){
            b = iter.next();
            if(b.getID() == id){
                borrows.remove(b);
                return;
            }
        }
    }

    public Borrow getBorrowByID(int id){
        Iterator<Borrow> iter = borrows.iterator();
        Borrow b = null;
        while(iter.hasNext()){
            b = iter.next();
            if(b.getID() == id){
                return b;
            }
        }
        return null;
    }


}
