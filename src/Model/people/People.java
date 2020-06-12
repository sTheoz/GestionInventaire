package src.people;

public class People {
    
    private String name;
    private String address;
    private int id;

    public People(String n, String a, int id){
        this.name = n;
        setAddress(a);
        this.id = id;
    }

    /*public People(PeopleDemo p, String name){
        this.id = p.getId();
        this.name = name;
        this.address = null;
    }*/

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
}