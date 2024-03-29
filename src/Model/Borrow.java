package src.Model;

import java.util.GregorianCalendar;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import src.Model.devices.Device;


/**
 * Borrow est une classe représentant un emprunt
 * 
 * @author Lucas NAVETEUR et Théo SZATKOWSKI
 * @version 1.0
 */
public class Borrow implements Serializable{

    private GregorianCalendar dateBorrow;
    private GregorianCalendar dateEndBorrow;
    private String justification;
    private ArrayList<Device> devices;
    private User borrower;
    private int id;

    private static final long serialVersionUID = 1L;

    public Borrow(GregorianCalendar date, GregorianCalendar endBorrow, String justif, User borrower, int id){
        super();
        this.dateBorrow = date;
        this.justification = justif;
        this.dateEndBorrow = endBorrow;
        devices = new ArrayList<Device>();
        this.borrower = borrower;
        this.id = id;
    }

    @Override
    public String toString(){
        return  "[" + this.id + "] " + borrower.getFirstName() + " " + borrower.getName() + " borrow " + devices.toString() + " pour la raison: " + justification + "\ndepuis le " + getDate() + " jusqu'au " + getEndBorrow();
    }

    public int getID(){
        return this.id;
    }

    public String getDate(){
        String str = "";
        str =  dateBorrow.get(Calendar.DATE) + "/" + (dateBorrow.get(Calendar.MONTH)+1) + "/" + dateBorrow.get(Calendar.YEAR); 
        return str;
    }
    
    public String getEndBorrow(){
        String str = "";
        str =  dateEndBorrow.get(Calendar.DATE) + "/" + (dateEndBorrow.get(Calendar.MONTH)+1) + "/" + dateEndBorrow.get(Calendar.YEAR); 
        return str;
    }

    public GregorianCalendar getExpiration(){
        return this.dateEndBorrow;
    }

    public String getJustification(){
        return justification;
    }

    public User getBorrower(){
        return borrower;
    }

    public int getIDBorrower(){
        return borrower.getID();
    }

    public void setEndBorrow(GregorianCalendar end){
        this.dateEndBorrow = end;
    }

    public void setJustification(String justif){
        this.justification = justif;
    }

    public void addDevice(Device d){
        if(d.isAvailable()){
            devices.add(d);
            d.setUnavailable();
        }else{
            System.out.println("Cet appareil n'est pas disponible : " + d.toString());
        }
    }

    public void removeDevice(Device d){
        devices.remove(d);
    }

    /**
     * Sauvegarde les données
     */
    public void serialise(){
        try{
            File fichier =  new File("data/borrowController"+ serialVersionUID +".ser") ;

            // ouverture d'un flux sur un fichier
            ObjectOutputStream oos =  new ObjectOutputStream(new FileOutputStream(fichier)) ;
    
            // sérialization de l'objet
            oos.writeObject(this) ;
            oos.close();
        }catch(IOException e){
            System.err.println("Errorrrr 1");
        }  
    }
}