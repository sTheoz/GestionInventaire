package src.Model;

public class Storage {
    
    private String name;
    private String location;

    public Storage(String name, String locate){
        this.name = name;
        this.location = locate;
    }

    public String getName(){
        return name;
    }

    public String getLocation(){
        return location;        
    }

    public void setLocation(String l){
        this.location = l;
    }

    public void setName(String n){
        this.name = n;
    }

    @Override
    public String toString(){
        return this.name + " : " + this.location; 
    }
}