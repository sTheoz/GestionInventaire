package src.Model;

public class User {
    
    private String name;
    private String firstName;
    private String address;
    private String phoneNumber;
    private String mail;

    public User(String firstName, String name, String addr, String phoneNumber, String mail){
        this.firstName = name;
        this.name = name;
        this.address = addr;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
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
}