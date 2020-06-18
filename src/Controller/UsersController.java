package src.Controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import src.Model.User;

/**
 * UsersController est une classe représentant le point de contact pour toutes les actions que l'on a avec 
 * les utilisateurs (@see User)
 * 
 * @author Lucas NAVETEUR et Théo SZATKOWSKI
 * @version 1.0
 */
public class UsersController implements Serializable{
    
    private ArrayList<User> users;
    private int id;

    private static final long serialVersionUID = 21L;

    /**
     * UsersController est un signeleton et ne peut pas être créé
     */
    private UsersController(){
        this.id = 0;
        users = new ArrayList<User>();
    }

    /** Instance unique non préinitialisée */
    private static UsersController INSTANCE = null;
     
    /** 
     * Récupère ou crée l'instance de la classe
     * */
    public static UsersController getInstance()
    {           
        if (INSTANCE == null)
        {   INSTANCE = new UsersController(); 
        }
        return INSTANCE;
    }
    /**
     * Créer et retourne un utilisateur User
     * @param firstName prénom pour la création d'un User
     * @param name nom de famille pour la création d'un User
     * @param addr adresse postal pour la création d'un User
     * @param phoneNumber numéro de téléphone pour la création d'un User
     * @param mail email pour la création d'un User
     * @return un utilisateur User
     */
    public User addUser(String firstName, String name, String addr, String phoneNumber, String mail){
        User u = new User(firstName, name, addr, phoneNumber, mail, getId());
        users.add(u);
        return u;
    }
    /**
     * Retire un utilisateur p de l'annuaire
     * @param p un utilisateur
     */
    public void removeUser(User p){
        users.remove(p);
    }

    /**
     * Recupère un ID disponible
     * @return id
     */
    public int getId(){
        int idR = this.id;
        this.id++;
        return idR;
    }

    /**
     * Récupère tous les utilisateurs stockés dans users
     * @return ArrayList de User
     */
    public ArrayList<User> getUsers(){
        return users;
    }

    /**
     * Récupère un Utilisateur en fonction de son id ou null si non trouvé
     * @param id id d'un utilisateur
     * @return user trouvé ou null
     */
    public User getUserByID(int id){
        User u;
        Iterator<User> iter = users.iterator();
        while(iter.hasNext()){
            u = iter.next();
            if(u.getID() == id){
                return u;
            }
        }
        return null;
    }

    /**
     * Permet d'initialiser le singleton lors de la désérialisation du fichier data/usersController.ser
     */
    public void deserialise(ArrayList<User> users, int id){
        this.users = users;
        this.id = id;
    }
}