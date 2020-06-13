package src.Model.devices;

import src.Model.Storage;

public class Tablet extends Phone{

	public Tablet (String ref, String nom, String marque, double prix, SE se, double sz, State st, Storage location, Device.Type type, int id){
		super(ref, nom, marque, prix, se, sz, st, location, type, id);
	}
	
}
