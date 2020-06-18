package src.Model;

import java.io.Serializable;

/**
 * User est une classe représentant un utilisateur
 * 
 * @author Lucas NAVETEUR et Théo SZATKOWSKI
 * @version 1.0
 */

public class User implements Serializable{
    
    private String name;
    private String firstName;
    private String address;
    private String phoneNumber;
    private String mail;
    private int id;

    private static final long serialVersionUID = 2L;


    public User(String firstName, String name, String addr, String phoneNumber, String mail, int id){
        this.firstName = firstName;
        this.name = name;
        this.address = addr;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.id = id;
    }

    public int getID(){
        return this.id;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public String getMail(){
        return this.mail;
    }

    public String getName(){
        return this.name;
    }

    public String getAddress(){
        return this.address;
    }

    public void setAddress(String a){
        this.address = a;
    }

    public void setFName(String fn){
        this.firstName = fn;
    }

    public void setPhone(String n){
        this.phoneNumber = n;
    }

    public void setMail(String m){
        this.mail = m;
    }

    @Override
    public String toString(){
        return firstName + " " + name;
    }
}