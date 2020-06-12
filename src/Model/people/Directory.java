package src.Model.people;

import java.util.ArrayList;

public class Directory {
    
    private ArrayList<People> users;

    private Directory(){
        users = new ArrayList<People>();
    }

    /** Instance unique non préinitialisée */
    private static Directory INSTANCE = null;
     
    /** Point d'accès pour l'instance unique du Stock */
    public static Directory getInstance()
    {           
        if (INSTANCE == null)
        {   INSTANCE = new Directory(); 
        }
        return INSTANCE;
    }

    public void addUser(People p){
        users.add(p);
    }

    public void removeUser(People p){
        users.remove(p);
    }

    public ArrayList<People> getUsers(){
        return users;
    }
}