package src.Controller;

import java.util.ArrayList;
import src.Model.User;

public class UsersController {
    
    private ArrayList<User> users;

    private UsersController(){
        users = new ArrayList<User>();
    }

    /** Instance unique non préinitialisée */
    private static UsersController INSTANCE = null;
     
    /** Point d'accès pour l'instance unique du Stock */
    public static UsersController getInstance()
    {           
        if (INSTANCE == null)
        {   INSTANCE = new UsersController(); 
        }
        return INSTANCE;
    }

    public void addUser(String firstName, String name, String addr, String phoneNumber, String mail){
        users.add(new User(firstName, name, addr, phoneNumber, mail));
    }

    public void removeUser(User p){
        users.remove(p);
    }

    public ArrayList<User> getUsers(){
        return users;
    }
}