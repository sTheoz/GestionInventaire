package src.Model.devices;

import src.Model.Storage;

/**
 * PlayingRemote est une classe représentant une manette de jeu
 * 
 * @author Lucas NAVETEUR et Théo SZATKOWSKI
 * @version 1.0
 */
public class PlayingRemote extends Device{

	private static final long serialVersionUID = 413L;
	
	public PlayingRemote (String ref, String name, String brand, double price, State st, Storage location, Device.Type type, int id){
		super(ref, name, brand, price, st, location, type, id);
	}
	
	public String toString(){
		return super.toString();
	}
}
