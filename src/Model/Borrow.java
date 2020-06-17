package src.Model;

import java.util.Date;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import src.Model.devices.Device;

public class Borrow implements Serializable{

    private Date dateBorrow;
    private Date dateEndBorrow;
    private String justification;
    private ArrayList<Device> devices;
    private User borrower;

    private static final long serialVersionUID = 1L;

    public Borrow(Date date, Date endBorrow, String justif, User borrower){
        super();
        this.dateBorrow = date;
        this.justification = justif;
        this.dateEndBorrow = endBorrow;
        devices = new ArrayList<Device>();
        this.borrower = borrower;
    }

    @Override
    public String toString(){
        return borrower + " borrow " + devices.toString() + " for " + justification + " since " + dateBorrow + " to " + dateEndBorrow;
    }

    public Date getDate(){
        return dateBorrow;
    }
    
    public Date getEndBorrow(){
        return dateEndBorrow;
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

    public void setEndBorrow(Date end){
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

    public void serialise(){
        try{
            File fichier =  new File("data/borrowController"+ serialVersionUID +".ser") ;

            // ouverture d'un flux sur un fichier
            ObjectOutputStream oos =  new ObjectOutputStream(new FileOutputStream(fichier)) ;
    
            // sérialization de l'objet
            oos.writeObject(this) ;

        }catch(IOException e){
            System.err.println("Errorrrr 1");
        }  
    }
}