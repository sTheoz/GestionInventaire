package src.Model;

public class Storage {
    private int id;
    private String name;
    private String location;

    public Storage(String name, String locate, int id){
        this.name = name;
        this.location = locate;
        this.id = id;
    }

    public int getID(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getLocation(){
        return this.location;        
    }

    public void setLocation(String l){
        this.location = l;
    }

    public void setName(String n){
        this.name = n;
    }

    public void setID(int id){
        this.id = id;
    }
}