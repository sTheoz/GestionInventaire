package src.Model;

import java.io.Serializable;

/**
 * Storage est une classe représentant un lieu de stockage
 * 
 * @author Lucas NAVETEUR et Théo SZATKOWSKI
 * @version 1.0
 */
public class Storage implements Serializable{
    private int id;
    private String name;
    private String location;

    private static final long serialVersionUID = 3L;

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

    @Override
    public String toString(){
        return  "[" + this.id + "] " + this.name + " : " + this.location; 
    }
}