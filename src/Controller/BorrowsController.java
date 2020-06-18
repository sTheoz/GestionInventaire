package src.Controller;

import src.Model.*;
import src.Model.devices.Device;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Scanner;

/**
 * BorrowsController est une classe représentant le point de contact pour toutes les actions que l'on a avec 
 * les emprunts (@see Borrow)
 * 
 * @author Lucas NAVETEUR et Théo SZATKOWSKI
 * @version 1.0
 */
public class BorrowsController implements Serializable{

    private ArrayList<Borrow> borrows;
    private static final long serialVersionUID = 15151515151515L;
    private int id;
    
    /**
     * BorrowsController est un signeleton et ne peut pas être créé
     */
    public BorrowsController(){
        borrows = new ArrayList<Borrow>();
        this.id = 0;
    }
    
    /**
     * Renvoie tous les emprunts
     * @return tous les emprunts
     */
    public ArrayList<Borrow> getBorrows(){
        return borrows;
    }

    /**
     * Renvoie la description de tous les emprunts de la liste borrows
     * @param borrows liste d'emprunts
     * @return la description de tous les emprunts de la liste borrows
     */
    public String toStringBorrows(ArrayList<Borrow> borrows){
        String str = "";
        Iterator<Borrow> iter = borrows.iterator();
        while(iter.hasNext()){
            str += iter.next().toString()+"\n";
        }
        return str;
    }

    /**
     * Renvoie la description des emprunts d'un utilisateur
     * @param borrows liste d'emprunts
     * @param IDUser id d'utilisateur
     * @return la description des emprunts d'un utilisateur
     */
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

    /**
     * Renvoie la description de l'emprunt avec l'id id
     * @param id id de l'emprunt
     * @return La description de l'emprunt ou une chaine vide si non trouvé
     */
    public String toStringBorrowsById(int id){
        Borrow b;
        Iterator<Borrow> iter = borrows.iterator();
        while(iter.hasNext()){
            b = iter.next();
            if(b.getID() == id){
                return b.toString();
            }
        }
        return "";
    }

    /**
     * Renvoie la description des emprunts avec la raison j
     * @param borrows liste d'emprunts
     * @param j Raison de l'emprunt
     * @return la description des emprunts avec la raison j
     */
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

    /**
     * Renvoie la description des emprunts qui ne sont pas rendu à temps
     * @param borrows liste d'emprunts
     * @return la description des emprunts qui ne sont pas rendu à temps
     */
    public String toStringBorrowsInLate(ArrayList<Borrow> borrows){
        String str = "";
        Iterator<Borrow> iter = borrows.iterator();
        Borrow b;
        GregorianCalendar d = new GregorianCalendar();
        while(iter.hasNext()){
            b = iter.next();
            if(b.getExpiration().before(d) ){
                str += b.toString()+"\n";
            }
        }
        return str;
    }

     /** Instance unique non préinitialisée */
    private static BorrowsController INSTANCE = null;
    
     /** 
     * Récupère ou crée l'instance de la classe
     */
    public static BorrowsController getInstance(){           
        if (INSTANCE == null){ 
            INSTANCE = new BorrowsController(); 
        }
        return INSTANCE;
    }
    
    /**
     * Ajoute un emprunt
     * @param b un emprunt
     */
    public void addBorrow(Borrow b){
        borrows.add(b);
    }

    /**
     * Supprime un emprunt
     * @param b un emprunt
     */
    public void removeBorrow(Borrow b){
        borrows.remove(b);
    }

    /**
     * Récupère un id disponible
     * @return un id disponible
     */
    public int getId(){
        int idR = this.id;
        this.id++;
        return idR;
    }

    /**
     * Modifie la date limite de rendu pour l'emprunt
     * @param id id de l'emprunt
     * @param input Récupère les données de l'entrée standard
     */
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

    /**
     * Modifie la raison de l'emprunt
     * @param id id l'emprunt
     * @param input Récupère les données de l'entrée standard
     */
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

    /**
     * Ajoute un appareil à l'emprunt
     * @param b un emprunt
     * @param d un appareil
     */
    public void addDevice(Borrow b, Device d){
        b.addDevice(d);
    }

    /**
     * Enleve un appareil d'un emprunt
     * @param b un emprunt
     * @param d un appareil
     */
    public void deleteDevice(Borrow b , Device d){
        b.removeDevice(d);
    }

    /**
     * Rend un emprunt
     * @param id id d'un emprunt
     */
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

    /**
     * Récupère un emprunt en fonction de son id
     * @param id id de l'emprunt
     * @return emprunt avec l'id id
     */
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

    /**
     * Permet d'initialiser le singleton lors de la désérialisation du fichier data/storageController.ser
     * @param borrows liste des emprunts
     * @param id id disponible
     */
    public void deserialise(ArrayList<Borrow> borrows, int id){
        this.borrows = borrows;
        this.id = id;
    }
}
