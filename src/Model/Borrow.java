package src.Model;

import java.sql.Date;
import java.util.ArrayList;
import src.Model.people.People;
import src.Model.devices.Device;

public class Borrow {

    private Date dateBorrow;
    private Date dateEndBorrow;
    private String justification;
    private ArrayList<Device> devices;
    private People borrower;

    public Borrow(Date date, Date endBorrow, String justif, People borrower){
        super();
        this.dateBorrow = date;
        this.justification = justif;
        this.dateEndBorrow = endBorrow;
        devices = new ArrayList<Device>();
        this.borrower = borrower;
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

    public People getBorrower(){
        return borrower;
    }

    public void setEndBorrow(Date end){
        this.dateEndBorrow = end;
    }

    public void setJusitification(String justif){
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
}