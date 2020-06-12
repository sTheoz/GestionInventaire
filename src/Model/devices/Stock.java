package src.devices;

public class Stock {

    private int id;
    private int numberElement;

    private Stock(){
        super();
        id = 0;
        this.numberElement = 0;
    }

    private Stock(int id, int nbEle){
        super();
        this.id = id;
        this.numberElement = nbEle;
    }
     
    /** Instance unique non préinitialisée */
    private static Stock INSTANCE = null;
     
    /** Point d'accès pour l'instance unique du Stock */
    public static Stock getInstance()
    {           
        if (INSTANCE == null)
        {   INSTANCE = new Stock(); 
        }
        return INSTANCE;
    }

    public static Stock getInstance(int id, int nbEle)
    {           
        if (INSTANCE == null)
        {   INSTANCE = new Stock(id, nbEle); 
        }
        return INSTANCE;
    }

    public int getId(){
        int idR = this.id;
        this.id++;
        return idR;
    }

    public void incrementStock(){
        this.numberElement++;
    }

    public void decrementStock(){
        this.numberElement--;
    }

    public int getNbElement(){
        return numberElement;
    }

}