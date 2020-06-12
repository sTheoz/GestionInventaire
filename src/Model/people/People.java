package src.Model.people;

public class People {
    
    private String name;
    private String firstName;
    private String address;
    private String phoneNumber;
    private String mail;
    private int id;

    public People(String firstName, String name, String addr, String phoneNumber, String mail){
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

    public int getId(){
        return this.id;
    }

    public void setAddress(String a){
        this.address = a;
    }

    public void display(){
        System.out.println("I'm "+ this.getName() + " at " + this.getAddress() + " with ID " + this.getId());
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