package src.Model.devices;

import src.Model.Storage;

/**
 * Tablet est une classe représentant une tablette électronique
 * 
 * @author Lucas NAVETEUR et Théo SZATKOWSKI
 * @version 1.0
 */
public class Tablet extends Phone{

	private static final long serialVersionUID = 415L;

	public Tablet (String ref, String nom, String marque, double prix, SE se, double sz, State st, Storage location, Device.Type type, int id){
		super(ref, nom, marque, prix, se, sz, st, location, type, id);
	}
	
}
